package com.user.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.exception.UserNotFoundException;
import com.user.management.model.CreateUserRequest;
import com.user.management.model.CreateUserResponse;
import com.user.management.model.GetUserSpecificResponse;
import com.user.management.service.UserManagementServiceInterface;


@Service
public class UserManagementServiceImpl implements UserManagementServiceInterface{
	
	//@Autowired
	//private UserRepository

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

	@Override
	public GetUserSpecificResponse getUserSpeficicData(String userId) throws UserNotFoundException {
		
		// connect with DB, get with userSpecificDat
		GetUserSpecificResponse getUserSpecificResponse =  new GetUserSpecificResponse() ;
		
		// make a call to DB -- Optional<User> user object
		// if(user==null) { 			throw new UserNotFoundException("the requested user is not available in Data base", exception);
//} == thow exception where user is NA
		// DB user data -- 
		try {
	
    // null.set()
		getUserSpecificResponse.setAddress("h-2034,street1,Hyd");
		getUserSpecificResponse.setUserName(userId);
		getUserSpecificResponse.setEmailId("xyz@gmail.com");
		
		
		}catch(NullPointerException exception) {
			
			throw new UserNotFoundException("the requested user is not available in Data base", exception);
			
		}catch(Exception e) {
			
		}
		
		
		
		
		return getUserSpecificResponse;
	}

	@Override
	public String deleteUser(String userId) {
		
		return "user : "+ userId+ ": deleted successfully from the system";
	}

}
