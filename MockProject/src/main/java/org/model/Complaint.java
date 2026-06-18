package org.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Complaint 
{
	 private int ticketId;

	    private int studentId;

	    private int categoryId;

	    private String priority;

	    private String description;

	    private String status;

	    private Timestamp createdTime;

}
