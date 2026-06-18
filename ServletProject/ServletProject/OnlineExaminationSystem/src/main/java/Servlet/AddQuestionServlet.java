package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import exam.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addQuestionServlet")
public class AddQuestionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String examid = request.getParameter("examid");
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		String option4 = request.getParameter("option4");
		String answer = request.getParameter("answer");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
			"insert into question(exam_id,question_text,option1,option2,option3,option4,correct_answer) values(?,?,?,?,?,?,?)");

			ps.setInt(1, Integer.parseInt(examid));
			ps.setString(2, question);
			ps.setString(3, option1);
			ps.setString(4, option2);
			ps.setString(5, option3);
			ps.setString(6, option4);
			ps.setString(7, answer);

			int i = ps.executeUpdate();

			if(i > 0) {

				response.sendRedirect("AdminDashboard.html");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}