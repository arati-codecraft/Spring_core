package org.repositoryImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.model.Complaint;
import org.repository.ComplaintRepository;

import utility.DBConnection;

public class ComplaintRepositoryImpl   implements ComplaintRepository{

	@Override
	public boolean addComplaint(Complaint complaint) {

	    boolean status = false;

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String query =
	                "INSERT INTO complaints " +
	                "(student_id, category_id, priority, description, status) " +
	                "VALUES (?, ?, ?, ?, ?)";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, complaint.getStudentId());

	        ps.setInt(2, complaint.getCategoryId());

	        ps.setString(3, complaint.getPriority());

	        ps.setString(4, complaint.getDescription());

	        ps.setString(5, complaint.getStatus());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {

	            status = true;
	        }

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return status;
	}

	@Override
	public Complaint getComplaintById(int ticketId) {

	    Complaint complaint = null;

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String query =
	                "SELECT * FROM complaints " +
	                "WHERE ticket_id = ?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, ticketId);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {

	            complaint = new Complaint();

	            complaint.setTicketId(
	                    rs.getInt("ticket_id"));

	            complaint.setStudentId(
	                    rs.getInt("student_id"));

	            complaint.setCategoryId(
	                    rs.getInt("category_id"));

	            complaint.setPriority(
	                    rs.getString("priority"));

	            complaint.setDescription(
	                    rs.getString("description"));

	            complaint.setStatus(
	                    rs.getString("status"));

	            complaint.setCreatedTime(
	                    rs.getTimestamp("created_time"));
	        }

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return complaint;
	}

	@Override
	public boolean updateComplaint(
	        Complaint complaint) {

	    boolean status = false;

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String query =
	                "UPDATE complaints " +
	                "SET priority=?, " +
	                "description=?, " +
	                "status=? " +
	                "WHERE ticket_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1,
	                complaint.getPriority());

	        ps.setString(2,
	                complaint.getDescription());

	        ps.setString(3,
	                complaint.getStatus());

	        ps.setInt(4,
	                complaint.getTicketId());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {

	            status = true;
	        }

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return status;
	}

	@Override
	public boolean deleteComplaint(int ticketId) {

	    boolean status = false;

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String query =
	                "DELETE FROM complaints " +
	                "WHERE ticket_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, ticketId);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {

	            status = true;
	        }

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return status;
	}

	@Override
	public List<Complaint> getAllComplaints() {

	    List<Complaint> complaintList =
	            new ArrayList<>();

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String query =
	                "SELECT * FROM complaints";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Complaint complaint =
	                    new Complaint();

	            complaint.setTicketId(
	                    rs.getInt("ticket_id"));

	            complaint.setStudentId(
	                    rs.getInt("student_id"));

	            complaint.setCategoryId(
	                    rs.getInt("category_id"));

	            complaint.setPriority(
	                    rs.getString("priority"));

	            complaint.setDescription(
	                    rs.getString("description"));

	            complaint.setStatus(
	                    rs.getString("status"));

	            complaint.setCreatedTime(
	                    rs.getTimestamp("created_time"));

	            complaintList.add(complaint);
	        }

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return complaintList;
	}
    
}
