package com.crm.app.service;

import org.springframework.http.ResponseEntity;

import com.crm.app.dto.loginDTO;
import com.crm.app.dto.signupDTO;

public interface userService {

	ResponseEntity<?> userRegistration(signupDTO signupdto);

	

	ResponseEntity<?> Login(loginDTO logindto);



	ResponseEntity<?> forgotpassword(String email, String password);

}
