package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.model.Project;

public interface ProjectRepositoryJPA extends JpaRepository<Project, Integer> {

//	@Query("select c from Country c where c.name != :name")
	Project findById(Integer id);


}
