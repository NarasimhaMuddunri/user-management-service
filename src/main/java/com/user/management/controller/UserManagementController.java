package com.user.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.model.CreateUserRequest;
import com.user.management.model.CreateUserResponse;
import com.user.management.service.UserManagementServiceInterface;

@RestController
@RequestMapping("/user")
public class UserManagementController {
	
	
	@Autowired
	private UserManagementServiceInterface userManagementServiceInterface;
	
	
	@PostMapping("/createUser")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
		
		// here we ared doing validation
		
		CreateUserResponse createUserResponse = new CreateUserResponse();
		
		
		validateCreateUserRequest(createUserRequest, createUserResponse); // if it fails here, APi will be terminate here only.

	   if(!createUserResponse.isSuccess() && createUserResponse.getMessage()!=null) {
		   return  createUserResponse;
	   }
		
	   return userManagementServiceInterface.createUser(createUserRequest);

	}
	
	
	@GetMapping("/allUsers")
	public List<String> getAllUser() {

		return userManagementServiceInterface.getAllUsers();

	}
	
	
	public CreateUserResponse validateCreateUserRequest(CreateUserRequest createUserRequest, CreateUserResponse createUserResponse) {
		
		if(StringUtils.isEmpty(createUserRequest.getPassword())) {
			
			createUserResponse.setMessage("The Mandatory feild Password is Empty. Could you please provide it.");
			
			createUserResponse.setSuccess(false);
			
		}		
		
     return createUserResponse;		
	}

}
