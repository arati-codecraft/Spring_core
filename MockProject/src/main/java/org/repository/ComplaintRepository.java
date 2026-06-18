package org.repository;
import java.util.List;

import org.model.Complaint;
import org.repositoryImpl.ComplaintRepositoryImpl;
public interface ComplaintRepository 
{
	
	
	// Add Complaint
    boolean addComplaint(Complaint complaint);
    
 // View All Complaints
    List<Complaint> getAllComplaints();
    
    // Update Complaint
    boolean updateComplaint(Complaint complaint);
    
 // Delete Complaint
    boolean deleteComplaint(int ticketId);
    
 // Search Complaint
    Complaint getComplaintById(int ticketId);
}
