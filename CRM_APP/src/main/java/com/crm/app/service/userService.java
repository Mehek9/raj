package com.crm.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crm.app.dto.loginDTO;
import com.crm.app.dto.signupDTO;
import com.crm.app.entity.Contacts;
import com.crm.app.entity.user;

import jakarta.validation.Valid;

public interface userService {

	ResponseEntity<?> userRegistration(signupDTO signupdto);

	

	ResponseEntity<?> Login(loginDTO logindto);



//	ResponseEntity<?> forgotpassword(String email, String password);

	List<user> getuserdetails();



	public ResponseEntity<?> access(String email);



	public ResponseEntity<?> forgotPassword(String email);



public	ResponseEntity<?> validateOTP(String email, String otp);







ResponseEntity<?> resetPassword(@Valid loginDTO logindto);



void addContactToUser(Long userId, Contacts body);



List<Contacts> getContactsByUser(Long userId);














	

}
