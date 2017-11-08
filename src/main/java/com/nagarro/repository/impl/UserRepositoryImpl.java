package com.nagarro.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Constants;
import com.nagarro.model.EmpFeedback;
import com.nagarro.model.Login;
import com.nagarro.model.Project;
import com.nagarro.model.User;
import com.nagarro.repository.ProjectRowMapper;
import com.nagarro.repository.UserRepository;
import com.nagarro.repository.UserRowMapper;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public Login findByUsername(User user) {
		StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("findByUsernameSP");
		getUserStoredProcedure.setParameter("Username", user.getUsername());
		getUserStoredProcedure.setParameter("Password", user.getPassword());
		 
		// Stored procedure call
		getUserStoredProcedure.execute();
		Login login = new Login(new User());
		login.setJsp((String) getUserStoredProcedure.getOutputParameterValue("Jsp"));
		
		Object id =  getUserStoredProcedure.getOutputParameterValue("Id");
		if(id != null) {
			login.getUser().setId((Integer)id);
			login.getUser().setName((String)getUserStoredProcedure.getOutputParameterValue("Name"));
			login.getUser().setRoleid((Integer)getUserStoredProcedure.getOutputParameterValue("Role"));
			login.getUser().setManagerid((Integer)(getUserStoredProcedure.getOutputParameterValue("ManagerId") == null ? 0:getUserStoredProcedure.getOutputParameterValue("ManagerId")));
		}
		else {
			login.setMessage((String) getUserStoredProcedure.getOutputParameterValue("Message"));
		}
		System.out.println("the login:"+login);
		return login;
	}

	@Override
	public List<User> findByManagerId(User user) {
		long id = 0;
		if(user.getRoleid() == 2) {
			id= user.getId();
		}
		else {
			id = user.getManagerid();
		}
		System.out.println("The id:"+id);
		StoredProcedureQuery getUserStoredProcedure = em.createNamedStoredProcedureQuery("findByManagerIdSP");
		getUserStoredProcedure.setParameter("Id", user.getId());
		getUserStoredProcedure.setParameter("ManagerId", id);
		getUserStoredProcedure.execute();
		List<User> employeeList = getUserStoredProcedure.getResultList();
		System.out.println("the list:"+employeeList.size());
		return employeeList;
	}

	@Override
	public List<Project> findProjectsByEmpId(Integer userid) {
		
		List<Project> projects = jdbcTemplate.query(Constants.EMPPROJECTS,new Object[] {userid}, new ProjectRowMapper());
		// TODO Auto-generated method stub
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Project> query = cb.createQuery(Project.class);
//		Root<Project> fromUpdates = query.from(Project.class);
//		Join<Project, ProjectEmpMap> details = fromUpdates.join("projectid");
//		Join<ProjectEmpMap, User> associate = details.join("empid");
//		
//		List<Predicate> conditions = new ArrayList<>();
//		
//		conditions.add(cb.equal(associate.get("id"), userid));
//
//		TypedQuery<Project> typedQuery = em.createQuery(query.where(conditions.toArray(new Predicate[] {})));
//		return typedQuery.getResultList();
		return projects;
	}

	@Override
	public List<EmpFeedback> findEmplsByProjectId(Integer id,Integer userId) {
		List<User> users = jdbcTemplate.query(Constants.PROJECTEMPS,new Object[] {id,userId}, new UserRowMapper());
		List<EmpFeedback> emps = new ArrayList<EmpFeedback>();
		for(User user: users) {
			Integer sum = jdbcTemplate.queryForObject(
					Constants.EMPFEEDBACKSUM, new Object[] { userId,user.getId() }, Integer.class);
			Integer count = jdbcTemplate.queryForObject(
					Constants.EMPFEEDBACKCOUNT, new Object[] { userId,user.getId() }, Integer.class);
			Integer value = 0;
			if(sum != null && count != null){
				value = sum.intValue()/count.intValue();
			}
			emps.add(new EmpFeedback(user, value));
		}
		System.out.println("list:"+emps);
		return emps;
	}

	@Override
	public List<EmpFeedback> findManagerEmplsByProjectId(Integer projectid, Integer managetId) {
		List<User> users = jdbcTemplate.query(Constants.PROJECTMANAGEREMPS,new Object[] {projectid}, new UserRowMapper());
		List<EmpFeedback> emps = new ArrayList<EmpFeedback>();
		System.out.println("list users:"+users);
		for(User user: users) {
			Integer sum = jdbcTemplate.queryForObject(
					Constants.MANAGEREMPFEEDBACKSUM, new Object[] { user.getId() }, Integer.class);
			Integer count = jdbcTemplate.queryForObject(
					Constants.MANAGEREMPFEEDBACKCOUNT, new Object[] { user.getId() }, Integer.class);
			Integer value = 0;
			if(sum != null && count != null){
				value = sum.intValue()/(count.intValue() *5);
			}
			emps.add(new EmpFeedback(user, value));
		}
		System.out.println("list:"+emps);
		return emps;
	}

}

