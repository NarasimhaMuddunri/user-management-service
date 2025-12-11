package com.user.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.management.model.CreateUserRequest;
import com.user.management.model.CreateUserResponse;
import com.user.management.service.UserManagementServiceInterface;


@Service
public class UserManagementServiceImpl implements UserManagementServiceInterface{

	@Override
	public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
		
		
		System.out.println("====UserName====="+ createUserRequest.getUserName());
		System.out.println("=====Password===="+ createUserRequest.getPassword());
		System.out.println("===Email======"+ createUserRequest.getEmail());
		System.out.println("====Address====="+ createUserRequest.getAddress());
		System.out.println("====phoneNumber====="+ createUserRequest.getPhoneNumber());

		
		
		CreateUserResponse createUserResponse = new CreateUserResponse();
		
		createUserResponse.setMessage("User Created Successfully");
		createUserResponse.setSuccess(true);
		
		
		return createUserResponse;
	}

	@Override
	public List<String> getAllUsers() {
		
		String userName1 = "Narasimha";
		String userName2 = "Narasimha1";	
		String userName3 = "Narasimha2";
		
		List<String> usersList = new ArrayList<>();
		usersList.add(userName1);
		usersList.add(userName2);
		usersList.add(userName3);	
		
		return usersList;
	}

}
