package com.crm.app.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.app.admin.dto.AdminDTO;
import com.crm.app.admin.dto.Contacts;
import com.crm.app.admin.dto.Ticket;
import com.crm.app.admin.dto.User;
import com.crm.app.admin.entity.Admin;
import com.crm.app.admin.service.AdminService;



@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	
	private final AdminService adminservice;
	
	@Autowired
	public AdminController(AdminService adminservice) {
		this.adminservice = adminservice;
	}
	
	@PostMapping("/addadmin")
	
	public ResponseEntity<String>addadmin(@RequestBody AdminDTO admindto){
		
		return adminservice.addadmin(admindto);
	}
	@PostMapping("/adminlogin")
	public ResponseEntity<String> login(@RequestBody Admin admindto){
		return adminservice.login(admindto);
	}
	
	@GetMapping("/getadmin")
	public List<Admin> getadmindetails(){
		return adminservice.getadmindetails();
	}
	
	@GetMapping("/getuserdetails")
	
	public List<User> getdetails(){
		return adminservice.getdetails();
	}
	
	@PutMapping("/giveapproval/{email}")
	public String access(@PathVariable String email) {
		return adminservice.access(email);
	}

	@GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        
        return  adminservice.getAllTickets();
    }
	
	@GetMapping("/{userId}")
	   public ResponseEntity<List<Contacts>> getContactsByUser(@PathVariable Long userId) {
	      return adminservice.getContactsByUser(userId);
	   }
}
