package com.crm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.app.dto.loginDTO;
import com.crm.app.dto.signupDTO;
import com.crm.app.service.userService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userService userservice;
	
	@PostMapping("/saveuser")
	public ResponseEntity<?> userRegistration(@RequestBody signupDTO signupdto){
		return userservice.userRegistration(signupdto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody loginDTO logindto){
		return userservice.Login(logindto);
	}
	@PutMapping("/forgotpassword/{email}/{password}")
	public ResponseEntity<?> forgotpassword(@PathVariable String email,@PathVariable String password){
		return userservice.forgotpassword(email,password);
	}
	
}


