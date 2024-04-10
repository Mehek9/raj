package com.crm.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalesRepresentative {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sl.no")
    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private String designation;
    private String category;
	public SalesRepresentative(Long id, String name, String email, String employeeId, String designation,
			String category) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeId = employeeId;
		this.designation = designation;
		this.category = category;
	}
	public SalesRepresentative() {
		super();
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public String getDesignation() {
		return designation;
	}
	public String getCategory() {
		return category;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "SalesRepresentative [id=" + id + ", name=" + name + ", email=" + email + ", employeeId=" + employeeId
				+ ", designation=" + designation + ", category=" + category + "]";
	}
	
	
}
