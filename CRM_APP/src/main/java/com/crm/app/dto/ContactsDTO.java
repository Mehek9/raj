package com.crm.app.dto;

import java.time.LocalDateTime;

import com.crm.app.entity.User;

public class ContactsDTO {

	private Long id;
    private String name;
    private String category;
    private String phoneNumber;
    private String email;
    private String country;
    private LocalDateTime dateCreated;
    private User user;
	public ContactsDTO(Long id, String name, String category, String phoneNumber, String email, String country,
			LocalDateTime dateCreated, User user) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.country = country;
		this.dateCreated = dateCreated;
		this.user = user;
	}
	public ContactsDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ContactsDTO [id=" + id + ", name=" + name + ", category=" + category + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", country=" + country + ", dateCreated=" + dateCreated + ", user=" + user + "]";
	}

    
}
