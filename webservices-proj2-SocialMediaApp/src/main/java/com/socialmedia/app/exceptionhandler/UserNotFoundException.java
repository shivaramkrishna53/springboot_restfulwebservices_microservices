package com.socialmedia.app.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "user id dosen't exist")
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
