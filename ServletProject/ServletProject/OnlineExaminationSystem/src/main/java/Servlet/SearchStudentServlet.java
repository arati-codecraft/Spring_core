package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import exam.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
			"select * from student where student_name like ?");

			ps.setString(1,"%"+name+"%");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				out.println(rs.getInt("student_id")+" ");

				out.println(rs.getString("student_name")+" ");

				out.println(rs.getString("email")+"<br>");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}