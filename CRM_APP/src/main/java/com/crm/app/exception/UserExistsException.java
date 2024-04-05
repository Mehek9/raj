package com.crm.app.exception;

public class UserExistsException extends Exception {

	
	 
	public UserExistsException() {
		super();
	}

	public UserExistsException(String msg) {
		super(msg);
		
	}
}
