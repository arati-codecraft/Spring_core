package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.dao.ComplaintDao;
import org.daoImpl.ComplaintDaoImpl;
import org.model.Complaint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewComplaints")
public class ViewComplaintServlet
        extends HttpServlet {

    private ComplaintDao dao =
            new ComplaintDaoImpl();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // GET DATA

        List<Complaint> complaintList =
                dao.getAllComplaints();

        // RESPONSE TYPE

        response.setContentType(
                "text/html");

        PrintWriter out =
                response.getWriter();

        // HTML START

        out.println("<html>");

        out.println("<head>");

        out.println("<title>");
        out.println("All Complaints");
        out.println("</title>");

        // CSS

        out.println(
                "<link rel='stylesheet' "
                + "href='CSS/style.css'>");

        // JAVASCRIPT

        out.println("<script>");

        out.println("function confirmDelete(){");

        out.println(
                "return confirm("
                + "'Are you sure you want to delete this complaint?'"
                + ");");

        out.println("}");

        out.println("</script>");

        out.println("</head>");

        out.println("<body>");

        // SIDEBAR

        out.println("<div class='sidebar'>");

        out.println("<div class='logo'>");
        out.println("ComplaintSystem");
        out.println("</div>");

        out.println("<ul>");

        out.println(
                "<li>"
                + "<a href='index.html'>"
                + "Dashboard"
                + "</a>"
                + "</li>");

        out.println(
                "<li>"
                + "<a href='addComplaint.html'>"
                + "Add Complaint"
                + "</a>"
                + "</li>");

        out.println(
                "<li>"
                + "<a href='viewComplaints'>"
                + "View Complaints"
                + "</a>"
                + "</li>");

        out.println(
                "<li>"
                + "<a href='searchComplaint.html'>"
                + "Search Complaint"
                + "</a>"
                + "</li>");

        out.println("</ul>");

        out.println("</div>");

        // TOPBAR

        out.println("<div class='topbar'>");

        out.println("<h2>");
        out.println("View Complaints");
        out.println("</h2>");

        out.println("<div class='profile'>");
        out.println("Welcome Admin");
        out.println("</div>");

        out.println("</div>");

        // MAIN CONTENT

        out.println("<div class='main-content'>");

        out.println("<div class='card'>");

        out.println("<h1>");
        out.println("Complaint List");
        out.println("</h1>");

        // SEARCH BAR

        out.println(
                "<div class='search-bar'>");

        out.println(
                "<input type='text' "
                + "placeholder='Search complaint...' "
                + "class='search-input'>");

        out.println(
                "<button class='btn'>"
                + "Search"
                + "</button>");

        out.println("</div>");

        // TABLE START

        out.println("<table>");

        out.println("<tr>");

        out.println("<th>Ticket ID</th>");

        out.println("<th>Student ID</th>");

        out.println("<th>Category ID</th>");

        out.println("<th>Priority</th>");

        out.println("<th>Description</th>");

        out.println("<th>Status</th>");

        out.println("<th>Created Time</th>");

        out.println("<th>Actions</th>");

        out.println("</tr>");

        // LOOP DATA

        for(Complaint complaint
                : complaintList) {

            out.println("<tr>");

            // TICKET ID

            out.println(
                    "<td>"
                    + complaint.getTicketId()
                    + "</td>");

            // STUDENT ID

            out.println(
                    "<td>"
                    + complaint.getStudentId()
                    + "</td>");

            // CATEGORY ID

            out.println(
                    "<td>"
                    + complaint.getCategoryId()
                    + "</td>");

            // PRIORITY

            out.println(
                    "<td>"
                    + complaint.getPriority()
                    + "</td>");

            // DESCRIPTION

            out.println(
                    "<td>"
                    + complaint.getDescription()
                    + "</td>");

            // STATUS BADGE

            String statusClass = "";

            if(complaint.getStatus()
                    .equalsIgnoreCase(
                            "Open")) {

                statusClass =
                        "badge-open";
            }
            else if(complaint.getStatus()
                    .equalsIgnoreCase(
                            "In Progress")) {

                statusClass =
                        "badge-progress";
            }
            else {

                statusClass =
                        "badge-resolved";
            }

            out.println(
                    "<td>"
                    + "<span class='badge "
                    + statusClass
                    + "'>"
                    + complaint.getStatus()
                    + "</span>"
                    + "</td>");

            // CREATED TIME

            out.println(
                    "<td>"
                    + complaint.getCreatedTime()
                    + "</td>");

            // ACTION BUTTONS

            out.println("<td>");

            // EDIT BUTTON

            out.println(
                    "<a href='updateComplaint?ticketId="
                    + complaint.getTicketId()
                    + "'>"
                    + "<button class='action-btn edit-btn'>"
                    + "Edit"
                    + "</button>"
                    + "</a>");

            out.println(" ");

            // DELETE BUTTON

            out.println(
                    "<a href='deleteComplaint?ticketId="
                    + complaint.getTicketId()
                    + "' "
                    + "onclick='return confirmDelete()'>"
                    + "<button class='action-btn delete-btn'>"
                    + "Delete"
                    + "</button>"
                    + "</a>");

            out.println("</td>");

            out.println("</tr>");
        }

        // TABLE END

        out.println("</table>");

        out.println("</div>");

        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}