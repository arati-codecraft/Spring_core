package org.dao;
import java.util.*;

import org.model.Complaint;

public interface ComplaintDao {
	 boolean addComplaint(Complaint complaint);

	    List<Complaint> getAllComplaints();

	    Complaint getComplaintById(int ticketId);

	    boolean updateComplaint(Complaint complaint);

	    boolean deleteComplaint(int ticketId);
}
