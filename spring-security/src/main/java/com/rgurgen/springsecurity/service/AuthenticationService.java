package com.rgurgen.springsecurity.service;

import com.rgurgen.springsecurity.model.User;

public interface AuthenticationService {
	 User signInAndReturnJWT(User signInRequest);

}
