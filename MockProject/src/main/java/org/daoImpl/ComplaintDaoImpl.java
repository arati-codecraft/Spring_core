package org.daoImpl;

import java.util.List;

import org.dao.ComplaintDao;
import org.model.Complaint;
import org.repository.ComplaintRepository;
import org.repositoryImpl.ComplaintRepositoryImpl;

public class ComplaintDaoImpl implements ComplaintDao{
	
	private ComplaintRepository repository =
            new ComplaintRepositoryImpl();

	@Override
	public boolean addComplaint(
	        Complaint complaint) {

	    // Validation

	    if (complaint.getPriority() == null
	            || complaint.getPriority().isEmpty()) {

	        System.out.println(
	                "Priority Required");

	        return false;
	    }

	    if (complaint.getDescription() == null
	            || complaint.getDescription().isEmpty()) {

	        System.out.println(
	                "Description Required");

	        return false;
	    }

	    // Default Status

	    if (complaint.getStatus() == null
	            || complaint.getStatus().isEmpty()) {

	        complaint.setStatus("Open");
	    }

	    return repository.addComplaint(
	            complaint);
	}

	@Override
	public List<Complaint> getAllComplaints() {

	    return repository.getAllComplaints();
	}
	@Override
	public Complaint getComplaintById(
	        int ticketId) {

	    return repository.getComplaintById(
	            ticketId);
	}

	@Override
	public boolean updateComplaint(
	        Complaint complaint) {

	    if (complaint.getTicketId() <= 0) {

	        System.out.println(
	                "Invalid Ticket ID");

	        return false;
	    }

	    return repository.updateComplaint(
	            complaint);
	}
	@Override
	public boolean deleteComplaint(
	        int ticketId) {

	    if (ticketId <= 0) {

	        System.out.println(
	                "Invalid Ticket ID");

	        return false;
	    }

	    return repository.deleteComplaint(
	            ticketId);
	}
}
