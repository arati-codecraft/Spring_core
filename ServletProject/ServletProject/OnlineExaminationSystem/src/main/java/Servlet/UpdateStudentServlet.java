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

@WebServlet("/updateStudentServlet")
public class UpdateStudentServlet
extends HttpServlet {

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)

			throws ServletException,
			IOException {

		String id =
		request.getParameter("id");

		String course =
		request.getParameter("course");

		try {

			Connection con =
			DBConnection.getConnection();

			PreparedStatement ps =
			con.prepareStatement(
			"update students set course=? where student_id=?");

			ps.setString(1,course);

			ps.setInt(2,
			Integer.parseInt(id));

			int i =
			ps.executeUpdate();

			if(i > 0) {

				response.sendRedirect(
				"viewStudentServlet");
			}

		} catch(Exception e) {

			e.printStackTrace();
		}
	}
}