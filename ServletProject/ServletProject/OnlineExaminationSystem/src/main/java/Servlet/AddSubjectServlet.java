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

@WebServlet("/addSubjectServlet")
public class AddSubjectServlet
extends HttpServlet {

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)

			throws ServletException,
			IOException {

		String subjectname =
		request.getParameter(
		"subjectname");

		String subjectcode =
		request.getParameter(
		"subjectcode");

		try {

			Connection con =
			DBConnection.getConnection();

			PreparedStatement ps =
			con.prepareStatement(
			"insert into subject(subject_name,subject_code) values(?,?)");

			ps.setString(1,
			subjectname);

			ps.setString(2,
			subjectcode);

			int i =
			ps.executeUpdate();

			if(i > 0) {

				response.sendRedirect(
				"viewSubjectServlet");
			}

		} catch(Exception e) {

			e.printStackTrace();
		}
	}
}