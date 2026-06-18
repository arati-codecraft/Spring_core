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

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet
extends HttpServlet {

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)

			throws ServletException,
			IOException {

		String id =
		request.getParameter("id");

		try {

			Connection con =
			DBConnection.getConnection();

			PreparedStatement ps =
			con.prepareStatement(
			"delete from students where student_id=?");

			ps.setInt(1,
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