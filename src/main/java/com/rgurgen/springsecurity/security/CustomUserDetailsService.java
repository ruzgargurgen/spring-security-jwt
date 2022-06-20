package com.rgurgen.springsecurity.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rgurgen.springsecurity.model.User;
import com.rgurgen.springsecurity.service.UserService;
import com.rgurgen.springsecurity.utils.SecurityUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(username));

		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

		return UserPrincipal.builder().user(user).id(user.getId()).username(username).password(user.getPassword())
				.authorities(authorities).build();
	}

}
