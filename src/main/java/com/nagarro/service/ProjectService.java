package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.model.EmpFeedback;
import com.nagarro.model.Project;

@Service
public interface ProjectService{

	List<Project> findProjects(int id);

//	List<User> findProjectEmps(Integer id);

	List<EmpFeedback> findProjectEmps(Integer id, Integer userId);

	List<EmpFeedback> findProjectManagerEmps(Integer projectid, Integer managetId);

}
