package com.user.management.service;

import java.util.List;

import com.user.management.model.CreateUserRequest;
import com.user.management.model.CreateUserResponse;

public interface UserManagementServiceInterface {
	
	public CreateUserResponse createUser(CreateUserRequest createUserRequest);
	
	public List<String> getAllUsers();

}
