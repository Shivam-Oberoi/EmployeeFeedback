package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class ProjectEmpID implements Serializable {
		 
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project projectid;
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

}
