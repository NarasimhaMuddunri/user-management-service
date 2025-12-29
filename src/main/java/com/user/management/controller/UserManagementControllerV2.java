package com.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.model.v2.CreateUserRequestV2;
import com.user.management.model.v2.CreateUserResponsev2;
import com.user.management.service.v2.UserMgmtService;

@RequestMapping("/user")
@RestController
public class UserManagementControllerV2 {
	
	@Autowired
	UserMgmtService userMgmtService;
	
	
	@PostMapping(value ="/create")
	public CreateUserResponsev2 createUser(@RequestBody CreateUserRequestV2 createUserRequest) {
		
		CreateUserResponsev2 createUserResponse =	userMgmtService.createUser(createUserRequest);
		
		return createUserResponse;
	}
 

}
