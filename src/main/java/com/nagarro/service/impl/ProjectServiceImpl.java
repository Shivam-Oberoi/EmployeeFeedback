package com.nagarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.EmpFeedback;
import com.nagarro.model.Project;
import com.nagarro.repository.ProjectRepositoryJPA;
import com.nagarro.repository.UserRepository;
import com.nagarro.repository.UserRepositoryJPA;
import com.nagarro.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepositoryJPA userRepositoryJPA;
	
	@Autowired
	ProjectRepositoryJPA projectRepositoryJPA;

	@Override
	public List<Project> findProjects(int id) {
		List<Project> projects = userRepository.findProjectsByEmpId(id);
		System.out.println(projects);
		return projects;
	}

	@Override
	public List<EmpFeedback> findProjectEmps(Integer id, Integer userId) {
		
//		Project user = projectRepositoryJPA.findById(id);
//		System.out.println("user:"+user);
//		System.out.println("user project:"+user.getUsers());
//		System.out.println("user project12:"+user.getUsers().get(1).getFeedbackEmps());
//		user.getUsers().listIterator().
		return userRepository.findEmplsByProjectId(id, userId);
	}

	@Override
	public List<EmpFeedback> findProjectManagerEmps(Integer projectid, Integer managetId) {
		return userRepository.findManagerEmplsByProjectId(projectid, managetId);
	}

}
