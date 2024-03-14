package com.crm.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crm.app.dto.loginDTO;
import com.crm.app.dto.signupDTO;
import com.crm.app.entity.user;
import com.crm.app.repo.userRepo;

@Service
public class userServiceIMPL implements userService{

	@Autowired
	private userRepo userrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private EmailForRegistration emailforregistration;

	@Override
	public ResponseEntity<?> userRegistration(signupDTO signupdto) {
		user u1 = userrepo.findByEmail(signupdto.getEmail());
		user u2 = this.modelmapper.map(signupdto, user.class);
		
		if(u1==null) {
			userrepo.save(u2);
			emailforregistration.sendSimpleEmail(signupdto.getEmail(),  u2.getEmail()+u2.getPassword()+"you registration was successful for LOKIS crm app","Welcome To LOKIS CRM");
			return new ResponseEntity<>("{\"status\": \"logged in\"}", HttpStatus.OK);
			
			//{\"status\": \"logged in\"}
		}
		return new ResponseEntity<>("already exists", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> Login(loginDTO logindto) {
		user u3 = userrepo.findByEmail(logindto.getEmail());
		if(u3 == null) {
			return new ResponseEntity<>("Not registered",HttpStatus.BAD_REQUEST);
		}
		if(u3.getPassword().equals(logindto.getPassword())) {
			return new ResponseEntity<>("{\"status\": \"logged in\", \"data\": {\"id\": " + u3.getId() + ", \"email\": \"" + u3.getEmail() + "\", \"firstname\": \"" + u3.getFirstname() + "\"}}", HttpStatus.OK);
		}
		return new ResponseEntity<>("Incorrect password",HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> forgotpassword(String email, String password) {
		user u4=userrepo.findByEmail(email);
		if(u4 !=null) {
		u4.setPassword(password);
		userrepo.save(u4);
		emailforregistration.sendSimpleEmail(email, u4.getPassword(), "your request for password is approved ");	
			
			return new ResponseEntity<>("password reset successfully ",HttpStatus.OK);
		}
		return new ResponseEntity<>("Account Not Found",HttpStatus.BAD_REQUEST);
	}
	
	
	
 
}

