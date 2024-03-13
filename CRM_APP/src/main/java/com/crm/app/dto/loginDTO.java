package com.crm.app.dto;

public class loginDTO {

	private String email;
	
	private String password;

	public loginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public loginDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "loginDTO [email=" + email + ", password=" + password + "]";
	}
	
}
