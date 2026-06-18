package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.dao.ComplaintDao;
import org.daoImpl.ComplaintDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteComplaint")
public class DeleteComplaintServlet
        extends HttpServlet {

    private ComplaintDao dao =
            new ComplaintDaoImpl();

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

        // DELETE COMPLAINT

        boolean result =
                dao.deleteComplaint(
                        ticketId);

        // RESPONSE

        response.setContentType(
                "text/html");

        PrintWriter out =
                response.getWriter();

        out.println("<html>");

        out.println("<head>");

        out.println(
                "<link rel='stylesheet' href='css/style.css'>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='main-content'>");

        out.println("<div class='card'>");

        if(result) {

            out.println(
                    "<h2>Complaint Deleted Successfully</h2>");
        }
        else {

            out.println(
                    "<h2>Delete Failed</h2>");
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

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}