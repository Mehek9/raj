package com.example.dto;



public class userDto {

	
	
	
	private int id;

	private String name;
	
	private String email;

	private String organization;
	
	private String password;

	public userDto(int id, String name, String email, String organization, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.organization = organization;
		this.password = password;
	}

	public userDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "userDto [id=" + id + ", name=" + name + ", email=" + email + ", organization=" + organization
				+ ", password=" + password + "]";
	}
	
	
}
