package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exam.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select * from admin where email=? and password=?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				response.sendRedirect("AdminDashboard.html");
			} 
			else 
			{

				out.println("<h1>Invalid Email or Password</h1>");
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}