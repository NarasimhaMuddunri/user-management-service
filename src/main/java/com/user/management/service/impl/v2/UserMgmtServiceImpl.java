package com.user.management.service.impl.v2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.entity.UserEntity;
import com.user.management.model.v2.CreateUserRequestV2;
import com.user.management.model.v2.CreateUserResponsev2;
import com.user.management.repository.UserRepository;
import com.user.management.service.v2.UserMgmtService;

@Service
public class UserMgmtServiceImpl implements UserMgmtService{
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public CreateUserResponsev2 createUser(CreateUserRequestV2 createUserRequest) {
		
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setAddress(createUserRequest.getAddress());
		userEntity.setEmail(createUserRequest.getEmail());
		userEntity.setName(createUserRequest.getName());
		userEntity.setPhoneNumber(createUserRequest.getPhoneNumber());
		
		
		// DB call
	   UserEntity  response =	userRepository.save(userEntity);
	   
	   
	   CreateUserResponsev2 createUserResponse = new CreateUserResponsev2();
	   
	   createUserResponse.setId(response.getId());
	   createUserResponse.setAddress(response.getAddress());
	   createUserResponse.setName(response.getName());
	   createUserResponse.setPhoneNumber(response.getPhoneNumber());
	   createUserResponse.setEmail(response.getEmail());
	   
		
		return createUserResponse;
		
	}

}
