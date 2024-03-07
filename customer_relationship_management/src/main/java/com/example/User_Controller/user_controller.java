package com.example.User_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dto.userDto;
import com.example.dto.userRegSaveDto;
import com.example.service.userServices;

@ResponseStatus
@CrossOrigin
@RequestMapping("api/v1/user")
public class user_controller {
	
	@Autowired
	
	private userServices userservice;
	public String saveUser(@RequestBody userRegSaveDto userRegSaveDto) {
		
		String id =userservice.addUser(userRegSaveDto);
		return id;
		
	}

}
