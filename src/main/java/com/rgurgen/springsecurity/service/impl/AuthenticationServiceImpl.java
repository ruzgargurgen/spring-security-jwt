package com.rgurgen.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.rgurgen.springsecurity.model.User;
import com.rgurgen.springsecurity.security.UserPrincipal;
import com.rgurgen.springsecurity.security.jwt.IJwtProvider;
import com.rgurgen.springsecurity.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IJwtProvider jwtProvider;

	@Override
	public User signInAndReturnJWT(User signInRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getUserName(), signInRequest.getPassword()));

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		String jwt = jwtProvider.generateToken(userPrincipal);

		User signInUser = userPrincipal.getUser();
		signInUser.setToken(jwt);

		return signInUser;
	}
}