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

/**
 * Servlet implementation class AddComplaintServlet
 */
@WebServlet("/addComplaint")
public class AddComplaintServlet
        extends HttpServlet {

    private ComplaintDao dao =
            new ComplaintDaoImpl();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get Form Data

        int studentId =
                Integer.parseInt(
                        request.getParameter(
                                "studentId"));

        int categoryId =
                Integer.parseInt(
                        request.getParameter(
                                "categoryId"));

        String priority =
                request.getParameter(
                        "priority");

        String description =
                request.getParameter(
                        "description");

        // Create Object

        Complaint complaint =
                new Complaint();

        complaint.setStudentId(studentId);

        complaint.setCategoryId(categoryId);

        complaint.setPriority(priority);

        complaint.setDescription(description);

        complaint.setStatus("Open");

        // Call DAO

        boolean result =
                dao.addComplaint(
                        complaint);

        // Send Response

        response.setContentType(
                "text/html");

        PrintWriter out =
                response.getWriter();

        if(result) {

            out.println(
                    "<h2>Complaint Added Successfully</h2>");
        }
        else {

            out.println(
                    "<h2>Complaint Failed</h2>");
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
