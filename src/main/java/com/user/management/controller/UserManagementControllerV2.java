package com.user.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.model.v2.CreateUserRequestV2;
import com.user.management.model.v2.CreateUserResponsev2;
import com.user.management.model.v2.UpdateUserRequestV2;
import com.user.management.model.v2.UpdateUserResponseV2;
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
	
	@GetMapping("/getAllUsers")
	
	public List<CreateUserResponsev2> getAllUsers(){
		
		List<CreateUserResponsev2> usersList = userMgmtService.getAllUsers();
		
		return usersList;
	}
	
	@DeleteMapping("/delete/{userId}")

	public String deleteUser(@PathVariable int userId) {

		String message = userMgmtService.deleteUser(userId);

		return message;

	}
	
	@PutMapping("/update/{userId}")

	public UpdateUserResponseV2 updateUser(@RequestBody UpdateUserRequestV2 updateUserRequestV2, @PathVariable int userId) {

		return userMgmtService.updateUser(updateUserRequestV2, userId);
	}
	
}
 
