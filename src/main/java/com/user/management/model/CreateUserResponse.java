package com.user.management.model;

import org.springframework.stereotype.Component;

@Component
public class CreateUserResponse {
	
	private String message;
	
	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

	
	
}
