package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.Login;
import com.nagarro.model.User;
import com.nagarro.repository.UserRepository;
import com.nagarro.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Login findByUsername(User user) {
		return userRepository.findByUsername(user);
	}

	@Override
	public List<User> findByManagerId(User user) {
		return userRepository.findByManagerId(user);
	}
	
}
