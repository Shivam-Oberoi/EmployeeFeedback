package com.nagarro.model;

public class Constants {
	
	public static String EMPPROJECTS = "SELECT p.id,p.name\r\n" + 
			"FROM dbo.Project_Emp_map m\r\n" + 
			"JOIN dbo.project p\r\n" + 
			"ON m.project_id=p.id\r\n" + 
			"JOIN dbo.employee e\r\n" + 
			"ON m.emp_id=e.id"
			+ " WHERE e.id=?" ;
	
	public static String PROJECTEMPS = "SELECT e.name,e.id\r\n" + 
			"FROM dbo.Project_Emp_map m\r\n" + 
			"JOIN dbo.project p\r\n" + 
			"ON m.project_id=p.id\r\n" + 
			"JOIN dbo.employee e\r\n" + 
			"ON m.emp_id=e.id"
			+ " WHERE p.id=? AND e.roleid  NOT IN (SELECT id FROM employee_role WHERE upper(name) like 'manager') AND e.id <> ?" ;
	
	public static String PROJECTMANAGEREMPS = "SELECT e.name,e.id\r\n" + 
			"FROM dbo.Project_Emp_map m\r\n" + 
			"JOIN dbo.project p\r\n" + 
			"ON m.project_id=p.id\r\n" + 
			"JOIN dbo.employee e\r\n" + 
			"ON m.emp_id=e.id"
			+ " WHERE p.id=? AND e.roleid  NOT IN (SELECT id FROM employee_role WHERE upper(name) like 'manager')" ;
	
	public static String EMPFEEDBACKSUM = "SELECT sum(rating) FROM dbo.feedback_emp WHERE user_id=?  AND to_id=? ";
	
	public static String EMPFEEDBACKCOUNT = "SELECT count(to_id) FROM dbo.feedback_emp WHERE user_id=?  AND to_id=? ";
	
	public static String MANAGEREMPFEEDBACKSUM = "SELECT sum(rating) FROM dbo.feedback_emp  WHERE to_id=? GROUP BY to_id";
	
	public static String MANAGEREMPFEEDBACKCOUNT = "SELECT count(to_id) FROM dbo.feedback_emp  WHERE to_id=? GROUP BY to_id";
	
	
	}
