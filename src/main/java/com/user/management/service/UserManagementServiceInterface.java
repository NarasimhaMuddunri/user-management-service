package com.user.management.service;

import java.util.List;

import com.user.management.exception.UserNotFoundException;
import com.user.management.model.CreateUserRequest;
import com.user.management.model.CreateUserResponse;
import com.user.management.model.GetUserSpecificResponse;

public interface UserManagementServiceInterface {
	
	public CreateUserResponse createUser(CreateUserRequest createUserRequest);
	
	public List<String> getAllUsers(); // 	public List<User> getAllUsers();
	
	public GetUserSpecificResponse getUserSpeficicData(String userId) throws UserNotFoundException ;

	public String deleteUser(String userId);
}
