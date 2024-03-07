package com.example.service;

import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repo.userRepo;
import com.example.dto.userRegSaveDto;

@Service
public class userServiceIMPL implements userServices  {

	private userRepo userrepo;
	
	@Override
	public String addUser(userRegSaveDto userRegSaveDto) {
		
		User user= new User(
				userRegSaveDto.getName(),
				userRegSaveDto.getEmail(),
				userRegSaveDto.getOrganization(),
				userRegSaveDto.getPassword()
				
				);
		
		
		return null;
	}

}
