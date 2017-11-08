package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.model.User;

public interface UserRepositoryJPA extends JpaRepository<User, Integer> {
	
User findById(Integer id);

}
