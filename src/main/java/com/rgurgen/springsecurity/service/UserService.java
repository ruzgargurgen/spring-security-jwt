package com.rgurgen.springsecurity.service;

import java.util.List;
import java.util.Optional;

import com.rgurgen.springsecurity.model.User;

public interface UserService {

	Optional<User> findByUserName(String username);

	List<User> findAllUsers();

	User save(User user);

	User updateUser(User user,Long userId);

	void deleteUser(Long userId);
	
	 void makeAdmin(String username);

	
}
