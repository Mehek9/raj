package com.example.service;

import java.util.List;

import com.example.dto.userDto;
import com.example.dto.userRegSaveDto;

public interface userServices {

	String addUser(userRegSaveDto userRegSaveDto);

	List<userDto> getuser() ;

}
