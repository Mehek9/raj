package com.example.User_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dto.userDto;
import com.example.dto.userRegSaveDto;
import com.example.service.userServices;

@ResponseStatus
@CrossOrigin

public class user_controller {
	
	@Autowired
	
	
	private userServices userservice;
	
	@PostMapping(path="save")
	public String saveUser(@RequestBody userRegSaveDto userRegSaveDto) {
		
		String id =userservice.addUser(userRegSaveDto);
		return id;
		
	}
	@GetMapping("viewuser")
	public List<userDto> getuser()
	{
		List<userDto>getuser=userservice.getuser();
		return getuser;
		}

}
