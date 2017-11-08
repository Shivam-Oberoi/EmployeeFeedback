package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.model.Login;
import com.nagarro.model.User;

@Service
public interface UserService{

	Login findByUsername(User user);
	
	List<User> findByManagerId(User user);
}
