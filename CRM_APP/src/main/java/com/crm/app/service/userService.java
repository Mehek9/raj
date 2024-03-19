package com.crm.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crm.app.dto.loginDTO;
import com.crm.app.dto.signupDTO;
import com.crm.app.entity.user;

public interface userService {

	ResponseEntity<?> userRegistration(signupDTO signupdto);

	

	ResponseEntity<?> Login(loginDTO logindto);



//	ResponseEntity<?> forgotpassword(String email, String password);

	List<user> getuserdetails();



	public String access(String email);



	public ResponseEntity<?> forgotPassword(String email);



public	ResponseEntity<?> validateOTP(String email, String otp);



public ResponseEntity<?> resetPassword(String email, String password);




	

}
