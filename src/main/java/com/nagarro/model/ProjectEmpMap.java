package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProjectEmpMap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project projectid;
	@Id
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private User empid;
	
	public Project getProjectid() {
		return projectid;
	}
	public void setProjectId(Project projectid) {
		this.projectid = projectid;
	}
	public User getEmpid() {
		return empid;
	}
	public void setEmpid(User empid) {
		this.empid = empid;
	}
//	@EmbeddedId
//	private ProjectEmpID projectEmpID;
//	public ProjectEmpID getProjectEmpID() {
//		return projectEmpID;
//	}
//	public void setProjectEmpID(ProjectEmpID projectEmpID) {
//		this.projectEmpID = projectEmpID;
//	}
//	
	
	
	
}
