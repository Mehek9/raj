package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.Repo.userRepo;
import com.example.dto.userDto;
import com.example.dto.userRegSaveDto;

@Service
public class userServiceIMPL implements userServices  {

	@Autowired
	private userRepo userrepo;
	
	@Override
	public String addUser(userRegSaveDto userRegSaveDto) {
		
		User user= new User(
				userRegSaveDto.getName(),
				userRegSaveDto.getEmail(),
				userRegSaveDto.getOrganization(),
				userRegSaveDto.getPassword()
				
				);
		userrepo.save(user);
		return user.getName();
		
	}

	@Override
	public List<userDto> getuser() {
		List<User> getusers= userrepo.findAll();
		List<userDto>userDtoList= new ArrayList<>();
		
		for(User u:getusers) {
			userDto UserDto= new userDto(
					u.getId(),
					u.getName(),
					u.getEmail(),
					u.getOrganization(),
					u.getPassword()
					
					
					);
			userDtoList.add(UserDto);
		}
		
		return userDtoList;
	}

}
