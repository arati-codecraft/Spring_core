package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.dao.ComplaintDao;
import org.daoImpl.ComplaintDaoImpl;
import org.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchComplaint")
public class SearchComplaintServlet
        extends HttpServlet {

    private ComplaintDao dao =
            new ComplaintDaoImpl();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get Ticket ID

    	// Get Ticket ID Safely

    	String ticketIdParam =
    	        request.getParameter(
    	                "ticketId");

    	if(ticketIdParam == null
    	        || ticketIdParam.isEmpty()) {

    	    response.setContentType("text/html");

    	    PrintWriter out =
    	            response.getWriter();

    	    out.println("<h2>Ticket ID Required</h2>");

    	    return;
    	}

    	int ticketId =
    	        Integer.parseInt(ticketIdParam);
        // Search Complaint

        Complaint complaint =
                dao.getComplaintById(
                        ticketId);

        // Response

        response.setContentType(
                "text/html");

        PrintWriter out =
                response.getWriter();

        out.println("<html>");

        out.println("<body>");

        out.println("<h1>");
        out.println("Search Result");
        out.println("</h1>");

        // Check Complaint Found

        if(complaint != null) {

            out.println("<table border='1'>");

            out.println("<tr>");

            out.println("<th>Ticket ID</th>");

            out.println("<th>Student ID</th>");

            out.println("<th>Category ID</th>");

            out.println("<th>Priority</th>");

            out.println("<th>Description</th>");

            out.println("<th>Status</th>");

            out.println("</tr>");

            out.println("<tr>");

            out.println("<td>"
                    + complaint.getTicketId()
                    + "</td>");

            out.println("<td>"
                    + complaint.getStudentId()
                    + "</td>");

            out.println("<td>"
                    + complaint.getCategoryId()
                    + "</td>");

            out.println("<td>"
                    + complaint.getPriority()
                    + "</td>");

            out.println("<td>"
                    + complaint.getDescription()
                    + "</td>");

            out.println("<td>"
                    + complaint.getStatus()
                    + "</td>");

            out.println("</tr>");

            out.println("</table>");
        }
        else {

            out.println("<h2>");
            out.println("Complaint Not Found");
            out.println("</h2>");
        }

        out.println("</body>");

        out.println("</html>");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
