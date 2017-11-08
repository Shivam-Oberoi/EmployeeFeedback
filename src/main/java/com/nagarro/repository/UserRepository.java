package com.nagarro.repository;

import java.util.List;

import com.nagarro.model.EmpFeedback;
import com.nagarro.model.Login;
import com.nagarro.model.Project;
import com.nagarro.model.User;

public interface UserRepository {

Login findByUsername(User user);
	
	List<User> findByManagerId(User user);
	
	List<Project> findProjectsByEmpId(Integer id);
	
	List<EmpFeedback> findEmplsByProjectId(Integer id,Integer userId);

	List<EmpFeedback> findManagerEmplsByProjectId(Integer projectid, Integer managetId);
}
