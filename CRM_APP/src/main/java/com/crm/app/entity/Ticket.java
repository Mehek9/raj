package com.crm.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;   
	private String title;    
	private String description;  
	@Enumerated(EnumType.STRING)
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
