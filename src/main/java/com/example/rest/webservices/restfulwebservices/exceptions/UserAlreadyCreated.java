package com.example.rest.webservices.restfulwebservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserAlreadyCreated extends RuntimeException {
	public UserAlreadyCreated(String message) {
		super(message);
	}
}
