package com.crm.app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class loginDTO {

	@NotEmpty
	@Pattern(regexp = ".*@gmail\\.com$" , message="Email must contain @gmail.com")
	private String email;
	
	@NotEmpty
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$", message="password should contain min 8 characters with alphabets,numeric and special character ")
	
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
