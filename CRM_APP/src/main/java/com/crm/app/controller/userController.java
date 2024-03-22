package com.crm.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.crm.app.dto.loginDTO;
import com.crm.app.dto.signupDTO;
import com.crm.app.entity.user;
import com.crm.app.service.userService;

import jakarta.validation.Valid;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userService userservice;
	
	@PostMapping("/saveuser")
	public ResponseEntity<?> userRegistration( @Valid @RequestBody signupDTO signupdto){
		return userservice.userRegistration(signupdto);
	}
	@GetMapping("/getuser")
	public List<user> getusersdetails(){
		return userservice.getuserdetails();
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody loginDTO logindto){
		return userservice.Login(logindto);
	}
//	@PutMapping("/forgotpassword/{email}/{password}")
//	public ResponseEntity<?> forgotpassword(@PathVariable String email,@PathVariable String password){
//		return userservice.forgotpassword(email,password);
//	}
	
	@PutMapping("/giveapproval/{email}")
	public ResponseEntity<?> access(@PathVariable String email) {
		return userservice.access(email);
	}
	
	
	 @PostMapping("/forgot-password")
	    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> body) {
	        String email = body.get("email");
	        return userservice.forgotPassword(email);
	    }
	 @PostMapping("/validate-otp")
	    public ResponseEntity<?> validateOTP(@RequestBody Map<String, String> body) {
	        String email = body.get("email");
	        String otp = body.get("otp");
	        return userservice.validateOTP(email, otp);
	    }
	 @PutMapping("/reset-password")
	    public ResponseEntity<?> resetPassword( @Valid @RequestBody loginDTO logindto) {
	        
	        return userservice.resetPassword(logindto);
	    }
}



