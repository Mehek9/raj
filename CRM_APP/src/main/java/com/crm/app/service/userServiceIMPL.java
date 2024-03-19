package com.crm.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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
//			emailforregistration.sendEmailWithAttachment(signupdto.getEmail(),  " your registration was successful for LOKIS crm app","Welcome To LOKIS CRM", "welcome");
			   emailforregistration.sendEmailWithAttachment(signupdto.getEmail(),  " Your registration was successful for LOKIS crm app",u2.getFirstname(), "welcome");
		       
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
//		if(u3.isAccess()==false) {
//			return new ResponseEntity<>("Not permitted",HttpStatus.BAD_REQUEST);
//		}
		
		if(u3.getPassword().equals(logindto.getPassword())) {
			     
			return new ResponseEntity<>("{\"status\": \"logged in\", \"data\": {\"id\": " + u3.getId() + ", \"email\": \"" + u3.getEmail() + "\", \"firstname\": \"" + u3.getFirstname() + "\"}}", HttpStatus.OK);
		}
		
		
		return new ResponseEntity<>("Incorrect password",HttpStatus.BAD_REQUEST);
	}

//	@Override
//	public ResponseEntity<?> forgotpassword(String email, String password) {
//		user u4=userrepo.findByEmail(email);
//		if(u4 !=null) {
//		u4.setPassword(password);
//		userrepo.save(u4);
////		emailforregistration.sendSimpleEmail(email, u4.getPassword(), "your request for password is approved ");	
////			
//		return new ResponseEntity<>("{\"status\": \"Reset\"}", HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Account Not Found",HttpStatus.BAD_REQUEST);
//	}

	@Override
	public List<user> getuserdetails() {
		
		return userrepo.findAll();
	}

	@Override
	public String access(String email) {
		user u6 = userrepo.findByEmail(email);
		u6.setAccess(true);
		userrepo.save(u6);
		emailforregistration.sendEmailWithAttachment(email,  " your registration was successful for LOKIS crm app","Welcome To LOKIS CRM", "welcome");
		return "success";
	}
	 private Map<String, String> otpCache = new HashMap<>();

	@Override
	public ResponseEntity<?> forgotPassword(String email) {
		if (email == null || email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email cannot be empty");
        }
		 user u7 = userrepo.findByEmail(email);
	        if (u7 == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	        }
	        String otp = generateOTP();
	        otpCache.put(email, otp);
	        u7.setOtp(otp);
	        userrepo.save(u7);

	        emailforregistration.sendMail(email, "reset password", "  "+u7.getOtp(), otp);
	    	
	        
	        return ResponseEntity.ok("OTP sent successfully");
	}
	 private String generateOTP() {
	        // Generate a 6-digit OTP
	        Random random = new Random();
	        return String.format("%06d", random.nextInt(1000000));
	    }

	
	@Override
	public ResponseEntity<?> validateOTP(String email, String otp) {
		 String storedOTP = otpCache.get(email);
	        if (storedOTP == null || !storedOTP.equals(otp)) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
	        }
	        otpCache.remove(email);
	        return ResponseEntity.ok("OTP validated successfully");
		
	}

	


	@Override
	public ResponseEntity<?> resetPassword(String email, String password) {
		 user u8= userrepo.findByEmail(email);
	        if (u8 == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	        }

	        u8.setPassword(password);
	        userrepo.save(u8);
	        emailforregistration.sendEmailWithAttachment(email,  " your password reset was successful for LOKIS crm app",u8.getFirstname(), "welcome");
	        return ResponseEntity.ok("Password updated successfully");
		
		

	


	}


	
 
}

