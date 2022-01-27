package com.rgurgen.springsecurity.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.rgurgen.springsecurity.security.UserPrincipal;

public interface IJwtProvider {

	String generateToken(UserPrincipal auth);
	Authentication getAuthentication(HttpServletRequest request);
	boolean validateToken(HttpServletRequest request);

	

}
