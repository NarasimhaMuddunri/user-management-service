package com.user.management.service.impl.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.entity.UserEntity;
import com.user.management.model.v2.CreateUserRequestV2;
import com.user.management.model.v2.CreateUserResponsev2;
import com.user.management.model.v2.UpdateUserRequestV2;
import com.user.management.model.v2.UpdateUserResponseV2;
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

	@Override
	public List<CreateUserResponsev2> getAllUsers() {
		
		List<UserEntity> listOfUsers = 	userRepository.findAll();
		
		List<CreateUserResponsev2> createUserResponsev2UsersList = new ArrayList<>();
		
	  // prepared the response object
		for(UserEntity userEntity:   listOfUsers) {
			
			CreateUserResponsev2 createUserResponsev2 = new CreateUserResponsev2();
			createUserResponsev2.setId(userEntity.getId());
			createUserResponsev2.setName(userEntity.getName());
			createUserResponsev2.setEmail(userEntity.getEmail());
			createUserResponsev2.setPhoneNumber(userEntity.getPhoneNumber());
			createUserResponsev2.setAddress(userEntity.getAddress());
			createUserResponsev2UsersList.add(createUserResponsev2);
			
		}
		
		return createUserResponsev2UsersList;
	}

	@Override
	public String deleteUser(int userId) {
		
		Long id = (long) userId ;
		
		userRepository.deleteById(id);
		
		return "user deleted successfully from the system";
	}

	@Override
	public UpdateUserResponseV2 updateUser(UpdateUserRequestV2 updateUserRequestV2, int userId) {
		
		//userRepository.
		
	Optional<UserEntity> userEntityOptional =	userRepository.findById( (long) userId);
	
	UserEntity userEntity = userEntityOptional.get();
	
	userEntity.setAddress(updateUserRequestV2.getAddress());
	userEntity.setEmail(updateUserRequestV2.getEmail());
	userEntity.setName(updateUserRequestV2.getName());
	userEntity.setPhoneNumber(updateUserRequestV2.getPhoneNumber());
	
	UserEntity userEntityResponse =  userRepository.saveAndFlush(userEntity);
	
	
	UpdateUserResponseV2 updateUserResponseV2 = new UpdateUserResponseV2();
	
	updateUserResponseV2.setId(userEntityResponse.getId());
	updateUserResponseV2.setName(userEntityResponse.getName());
	updateUserResponseV2.setEmail(userEntityResponse.getEmail());
	updateUserResponseV2.setAddress(userEntityResponse.getAddress());
	updateUserResponseV2.setPhoneNumber(userEntityResponse.getPhoneNumber());
	
		return updateUserResponseV2;
	}
	
	

}
