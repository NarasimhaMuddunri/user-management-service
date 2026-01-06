package com.user.management.service.v2;

import java.util.List;

import com.user.management.model.v2.CreateUserRequestV2;
import com.user.management.model.v2.CreateUserResponsev2;
import com.user.management.model.v2.UpdateUserRequestV2;
import com.user.management.model.v2.UpdateUserResponseV2;

public interface UserMgmtService {
	
	public CreateUserResponsev2 createUser(CreateUserRequestV2 createUserRequest);
	
	public List<CreateUserResponsev2> getAllUsers();
	
	public String deleteUser(int userId);
	
	public UpdateUserResponseV2 updateUser(UpdateUserRequestV2 updateUserRequestV2, int userId);

}
