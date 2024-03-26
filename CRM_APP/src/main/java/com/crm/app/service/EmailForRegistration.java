package com.crm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
@Service
public class EmailForRegistration {

	@Autowired
	private JavaMailSender mailSender;
	
		
		public void sendEmailWithAttachment(String to, String subject, String text) {
	        MimeMessage message = mailSender.createMimeMessage();
	 
	        try {
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(text);
	      
	 
	            
	            String htmlContent = "<html><body><h1>Welcome to our platform!</h1>"
                        + "<p>We're excited to have you on board  {{text}}.</p>"
                        + "<img src='cid:welcomeImage'>"
                        + "</body></html>";
	            String result=htmlContent.replace("{{text}}", text);
    
	            helper.setText(result, true);

     FileSystemResource file = new FileSystemResource(new File("C:\\Users\\pkumpatla\\Downloads\\logo.png"));
     helper.addInline("welcomeImage", file);
	            mailSender.send(message);
	        } 
	        catch (MessagingException e) {
	            e.printStackTrace();
	        }
        	}


		

		public void sendMail(String to, String subject, String text) {
	        MimeMessage message = mailSender.createMimeMessage();
	 
	        try {
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(text);
	      
	 
	            
	            String htmlContent = "<html><body><h1>Welcome to our platform!</h1>"
                        + "<p>Your One Time Password (OTP) To Reset Your Password is :- <b> {{text}}.<b></p>"
                        + "<img src='cid:welcomeImage'>"
                        + "</body></html>";
	            String result=htmlContent.replace("{{text}}", text);
    
	            helper.setText(result, true);

     FileSystemResource file = new FileSystemResource(new File("C:\\Users\\pkumpatla\\Downloads\\logo.png"));
     helper.addInline("welcomeImage", file);
	            mailSender.send(message);
	        } 
	        catch (MessagingException e) {
	            e.printStackTrace();
	        }
        	}
		
		}
		
	
		
	
	

 

