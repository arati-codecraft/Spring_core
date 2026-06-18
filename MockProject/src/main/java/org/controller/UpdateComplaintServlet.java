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

@WebServlet("/updateComplaint")
public class UpdateComplaintServlet
        extends HttpServlet {

    private ComplaintDao dao =
            new ComplaintDaoImpl();

    // LOAD UPDATE FORM

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // GET TICKET ID

        String ticketIdParam =
                request.getParameter(
                        "ticketId");

        // VALIDATION

        if(ticketIdParam == null
                || ticketIdParam.isEmpty()) {

            response.getWriter().println(
                    "<h2>Ticket ID Required</h2>");

            return;
        }

        int ticketId =
                Integer.parseInt(
                        ticketIdParam);

        // GET COMPLAINT

        Complaint complaint =
                dao.getComplaintById(
                        ticketId);

        // RESPONSE

        response.setContentType(
                "text/html");

        PrintWriter out =
                response.getWriter();

        out.println("<html>");

        out.println("<head>");

        out.println("<title>");
        out.println("Update Complaint");
        out.println("</title>");

        out.println(
                "<link rel='stylesheet' href='CSS/style.css'>");

        out.println("</head>");

        out.println("<body>");

        // SIDEBAR

        out.println("<div class='sidebar'>");

        out.println("<div class='logo'>");
        out.println("ComplaintSystem");
        out.println("</div>");

        out.println("<ul>");

        out.println("<li><a href='index.html'>Dashboard</a></li>");

        out.println("<li><a href='addComplaint.html'>Add Complaint</a></li>");

        out.println("<li><a href='viewComplaints'>View Complaints</a></li>");

        out.println("</ul>");

        out.println("</div>");

        // TOPBAR

        out.println("<div class='topbar'>");

        out.println("<h2>");
        out.println("Update Complaint");
        out.println("</h2>");

        out.println("</div>");

        // MAIN CONTENT

        out.println("<div class='main-content'>");

        out.println("<div class='card'>");

        out.println("<h1>");
        out.println("Edit Complaint");
        out.println("</h1>");

        // FORM

        out.println(
                "<form action='updateComplaint' method='post'>");

        // HIDDEN TICKET ID

        out.println(
                "<input type='hidden' "
                + "name='ticketId' "
                + "value='"
                + complaint.getTicketId()
                + "'>");

        // PRIORITY

        out.println("<div class='form-group'>");

        out.println("<label>Priority</label>");

        out.println(
                "<select name='priority' class='form-control'>");

        out.println(
                "<option "
                + (complaint.getPriority().equals("Low")
                ? "selected" : "")
                + ">Low</option>");

        out.println(
                "<option "
                + (complaint.getPriority().equals("Medium")
                ? "selected" : "")
                + ">Medium</option>");

        out.println(
                "<option "
                + (complaint.getPriority().equals("High")
                ? "selected" : "")
                + ">High</option>");

        out.println("</select>");

        out.println("</div>");

        // DESCRIPTION

        out.println("<div class='form-group'>");

        out.println("<label>Description</label>");

        out.println(
                "<textarea "
                + "name='description' "
                + "class='form-control'>"
                + complaint.getDescription()
                + "</textarea>");

        out.println("</div>");

        // STATUS

        out.println("<div class='form-group'>");

        out.println("<label>Status</label>");

        out.println(
                "<select name='status' class='form-control'>");

        out.println(
                "<option "
                + (complaint.getStatus().equals("Open")
                ? "selected" : "")
                + ">Open</option>");

        out.println(
                "<option "
                + (complaint.getStatus().equals("In Progress")
                ? "selected" : "")
                + ">In Progress</option>");

        out.println(
                "<option "
                + (complaint.getStatus().equals("Resolved")
                ? "selected" : "")
                + ">Resolved</option>");

        out.println("</select>");

        out.println("</div>");

        // BUTTON

        out.println(
                "<button type='submit' class='btn'>");

        out.println("Update Complaint");

        out.println("</button>");

        out.println("</form>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    // UPDATE DATABASE

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int ticketId =
                Integer.parseInt(
                        request.getParameter(
                                "ticketId"));

        String priority =
                request.getParameter(
                        "priority");

        String description =
                request.getParameter(
                        "description");

        String status =
                request.getParameter(
                        "status");

        Complaint complaint =
                new Complaint();

        complaint.setTicketId(ticketId);

        complaint.setPriority(priority);

        complaint.setDescription(description);

        complaint.setStatus(status);

        boolean result =
                dao.updateComplaint(
                        complaint);

        response.setContentType(
                "text/html");

        PrintWriter out =
                response.getWriter();

        out.println("<html>");

        out.println("<head>") ;

        out.println(
                "<link rel='stylesheet' href=CSS/style.css'>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='main-content'>");

        out.println("<div class='card'>");

        if(result) {

            out.println(
                    "<h2>Complaint Updated Successfully</h2>");
        }
        else {

            out.println(
                    "<h2>Update Failed</h2>");
        }

        out.println("<br>");

        out.println(
                "<a href='viewComplaints'>"
                + "<button class='btn'>"
                + "Back To Complaints"
                + "</button>"
                + "</a>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }
}