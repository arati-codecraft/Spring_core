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

@WebServlet("/startExamServlet")
public class StartExamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String examid = request.getParameter("examid");

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(
			"select * from question where exam_id=?");

			ps.setInt(1, Integer.parseInt(examid));

			ResultSet rs = ps.executeQuery();

			out.println("<html><body>");
			out.println("<h1>Online Exam</h1>");

			out.println("<form action='submitexam' method='post'>");

			out.println("<input type='hidden' name='examid' value='"+examid+"'>");

			while(rs.next()) {

				out.println("<h3>"+rs.getString("question_text")+"</h3>");

				int qid = rs.getInt("question_id");

				out.println("<input type='radio' name='q"+qid+"' value='"+rs.getString("option1")+"'>"+rs.getString("option1")+"<br>");

				out.println("<input type='radio' name='q"+qid+"' value='"+rs.getString("option2")+"'>"+rs.getString("option2")+"<br>");

				out.println("<input type='radio' name='q"+qid+"' value='"+rs.getString("option3")+"'>"+rs.getString("option3")+"<br>");

				out.println("<input type='radio' name='q"+qid+"' value='"+rs.getString("option4")+"'>"+rs.getString("option4")+"<br><br>");
			}

			out.println("<button type='submit'>Submit Exam</button>");

			out.println("</form>");

			out.println("</body></html>");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}