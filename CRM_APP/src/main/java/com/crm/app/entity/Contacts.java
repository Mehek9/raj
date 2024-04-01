package com.crm.app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contacts {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String category;
	    private String phoneNumber;
	    private String email;
	    private String country;
	    @CreationTimestamp
	    @Column(name = "date_created")
	    private LocalDateTime dateCreated;

	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    @JsonIgnoreProperties("contacts")
	    private user user;


		public Contacts(Long id, String name, String category, String phoneNumber, String email, String country,
				LocalDateTime dateCreated, user user) {
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


		public Contacts() {
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


		public user getUser() {
			return user;
		}


		public void setUser(user user) {
		    this.user = user; // Assign the parameter to the field
		}



		@Override
		public String toString() {
			return "Contacts [id=" + id + ", name=" + name + ", category=" + category + ", phoneNumber=" + phoneNumber
					+ ", email=" + email + ", country=" + country + ", dateCreated=" + dateCreated + ", user=" + user
					+ "]";
		}
	
		
	    
}
