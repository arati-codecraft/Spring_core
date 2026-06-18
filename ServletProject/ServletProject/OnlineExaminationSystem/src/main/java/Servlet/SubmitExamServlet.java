package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exam.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitExamServlet")
public class SubmitExamServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String examid = request.getParameter("examid");

		int total = 0;
		int correct = 0;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
			"select * from question where exam_id=?");

			ps.setInt(1, Integer.parseInt(examid));

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				total++;

				int qid = rs.getInt("question_id");

				String correctAnswer =
				rs.getString("correct_answer");

				String studentAnswer =
				request.getParameter("q"+qid);

				PreparedStatement saveAnswer =
				con.prepareStatement(
				"insert into student_answer(student_id,exam_id,question_id,selected_answer) values(?,?,?,?)");

				saveAnswer.setInt(1,1);

				saveAnswer.setInt(2,
				Integer.parseInt(examid));

				saveAnswer.setInt(3,qid);

				saveAnswer.setString(4,
				studentAnswer);

				saveAnswer.executeUpdate();

				if(correctAnswer.equals(studentAnswer)) {

					correct++;
				}
			}

			int percentage =
			(correct * 100) / total;

			String status;

			if(percentage >= 40) {

				status = "Pass";

			} else {

				status = "Fail";
			}

			PreparedStatement ps2 =
			con.prepareStatement(
			"insert into result(student_id,exam_id,total_marks,obtained_marks,percentage,status) values(?,?,?,?,?,?)");

			ps2.setInt(1,1);

			ps2.setInt(2,
			Integer.parseInt(examid));

			ps2.setInt(3,total);

			ps2.setInt(4,correct);

			ps2.setInt(5,percentage);

			ps2.setString(6,status);

			ps2.executeUpdate();

			response.sendRedirect(
			"result.jsp?marks="+correct+
			"&total="+total+
			"&percentage="+percentage+
			"&status="+status);

		} catch(Exception e) {

			e.printStackTrace();
		}
	}
}