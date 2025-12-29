package com.user.management.service.v2;

import com.user.management.model.v2.CreateUserRequestV2;
import com.user.management.model.v2.CreateUserResponsev2;

public interface UserMgmtService {
	
	public CreateUserResponsev2 createUser(CreateUserRequestV2 createUserRequest);

}
