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

@WebServlet("/viewStudentServlet")
public class ViewStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from students");

			ResultSet rs = ps.executeQuery();

			out.println("<html>");
			out.println("<body>");

			out.println("<h1>Student List</h1>");

			out.println("<table border='1'>");

			out.println("<tr>");

			out.println("<th>ID</th>");

			out.println("<th>Name</th>");

			out.println("<th>Email</th>");

			out.println("<th>Course</th>");

			out.println("<th>Mobile</th>");

			out.println("<th>Update</th>");

			out.println("<th>Delete</th>");

			out.println("</tr>");

			while (rs.next()) {

				out.println("<tr>");

				out.println("<td>" + rs.getInt("student_id") + "</td>");

				out.println("<td>" + rs.getString("student_name") + "</td>");

				out.println("<td>" + rs.getString("email") + "</td>");

				out.println("<td>" + rs.getString("course") + "</td>");

				out.println("<td>" + rs.getString("mobile") + "</td>");

				out.println("<td>");

				out.println("<a href='UpdateStudent.html?id=" + rs.getInt("student_id") + "'>Update</a>");

				out.println("</td>");

				out.println("<td>");

				out.println("<a href='DeleteStudent?id=" + rs.getInt("student_id") + "'>Delete</a>");

				out.println("</td>");

				out.println("</tr>");
			}

			out.println("</table>");

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}