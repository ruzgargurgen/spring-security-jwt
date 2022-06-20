package com.rgurgen.springsecurity.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgurgen.springsecurity.model.Role;
import com.rgurgen.springsecurity.model.User;
import com.rgurgen.springsecurity.repos.UserRepository;
import com.rgurgen.springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user,Long userId) {
		User userEntity=userRepository.getOne(userId);
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setCreateTime(user.getCreateTime());
		userEntity.setRole(user.getRole());
		
		return userRepository.save(userEntity);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
	
	@Override
    @Transactional 
    public void makeAdmin(String userName)
    {
        userRepository.updateUserRole(userName, Role.ADMIN);
    }

}
