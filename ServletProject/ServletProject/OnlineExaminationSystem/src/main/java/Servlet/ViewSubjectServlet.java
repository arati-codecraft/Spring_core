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
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewSubjectServlet")
public class ViewSubjectServlet extends HttpServlet {

	protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from subject");

			ResultSet rs = ps.executeQuery();

			out.println("<h1>Subjects</h1>");

			out.println("<table border='1'>");

			out.println("<tr>");

			out.println("<th>ID</th>");

			out.println("<th>Subject Name</th>");

			out.println("<th>Subject Code</th>");

			out.println("</tr>");

			while (rs.next()) {

				out.println("<tr>");

				out.println("<td>" + rs.getInt("subject_id") + "</td>");

				out.println("<td>" + rs.getString("subject_name") + "</td>");

				out.println("<td>" + rs.getString("subject_code") + "</td>");

				out.println("</tr>");
			}

			out.println("</table>");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}