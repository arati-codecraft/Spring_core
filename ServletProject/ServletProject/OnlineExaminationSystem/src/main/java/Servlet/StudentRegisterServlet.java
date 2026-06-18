package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import exam.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/studentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String course = request.getParameter("course");
		String mobile = request.getParameter("mobile");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"insert into students(student_name,email,password,course,mobile) values(?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, course);
			ps.setString(5, mobile);

			int i = ps.executeUpdate();

			if (i > 0) {

				response.sendRedirect("StudentLogin.html");

			} else {

				out.println("<h1>Registration Failed</h1>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}