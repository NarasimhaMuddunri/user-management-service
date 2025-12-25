package com.user.management.controller;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.management.exception.UserNotFoundException;
import com.user.management.model.ErrorResponse;

@ControllerAdvice // Global Exception Handling
public class UserManagementGlobalException {


	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
		
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}


}
