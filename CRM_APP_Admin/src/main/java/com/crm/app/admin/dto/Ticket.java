package com.crm.app.admin.dto;




public class Ticket {

	
	private Long id;   
	private String title;    
	private String description;  
	
	private TicketStatus status;
 
	public Ticket(Long id, String title, String description, TicketStatus status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}
 
	public Ticket() {
		super();
	}
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
 
	public String getDescription() {
		return description;
	}
 
	public void setDescription(String description) {
		this.description = description;
	}
 
	public TicketStatus getStatus() {
		return status;
	}
 
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
 
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + "]";
	}	

}
