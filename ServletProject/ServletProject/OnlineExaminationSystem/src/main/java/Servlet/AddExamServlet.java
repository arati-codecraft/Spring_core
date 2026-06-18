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

@WebServlet("/addExamServlet")
public class AddExamServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String examname = request.getParameter("examname");
		String subject = request.getParameter("subject");
		String questions = request.getParameter("questions");
		String marks = request.getParameter("marks");
		String duration = request.getParameter("duration");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
			"insert into exam(exam_name,subject_name,total_questions,total_marks,exam_duration) values(?,?,?,?,?)");

			ps.setString(1, examname);
			ps.setString(2, subject);
			ps.setInt(3, Integer.parseInt(questions));
			ps.setInt(4, Integer.parseInt(marks));
			ps.setInt(5, Integer.parseInt(duration));

			int i = ps.executeUpdate();

			if(i > 0) {

				response.sendRedirect("AdminDashboard.html");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}