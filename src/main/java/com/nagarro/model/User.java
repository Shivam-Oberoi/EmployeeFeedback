package com.nagarro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@Entity
@Table(name = "Employee", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
@NamedStoredProcedureQueries(value = {
@NamedStoredProcedureQuery(name = "findByUsernameSP", procedureName = "dbo.findByUsername ", parameters = {
		@StoredProcedureParameter(name = "Username", mode = ParameterMode.IN, type = String.class),
		@StoredProcedureParameter(name = "Password", mode = ParameterMode.IN, type = String.class),
		@StoredProcedureParameter(name = "Id", mode = ParameterMode.OUT, type = Integer.class),
		@StoredProcedureParameter(name = "Name", mode = ParameterMode.OUT, type = String.class),
		@StoredProcedureParameter(name = "Role", mode = ParameterMode.OUT, type = Integer.class),
		@StoredProcedureParameter(name = "Jsp", mode = ParameterMode.OUT, type = String.class),
		@StoredProcedureParameter(name = "Message", mode = ParameterMode.OUT, type = String.class),
		@StoredProcedureParameter(name = "ManagerId", mode = ParameterMode.OUT, type = Integer.class)}),
@NamedStoredProcedureQuery(name = "findByManagerIdSP", procedureName = "dbo.findByManagerId ", resultClasses = { User.class },
	parameters = {
				@StoredProcedureParameter(name = "Id", mode = ParameterMode.IN, type = Long.class),
				@StoredProcedureParameter(name = "ManagerId", mode = ParameterMode.IN, type = Long.class)
				})
})
public class User {

	@Id
	private int id;
	private String name;
	private String username;
	private String password;
	private int roleid;
	@Column(name="managerid", columnDefinition="bigint default '2'")
	private long managerid;
//	@ManyToMany
//	@JoinTable(name = "Project_emp_map", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
//	private List<Project> projects;
	
//	@Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy="toid", fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "area_woj_id")
	private List<FeedbackEmp> feedbackEmps;

	public User() {
	}

	public User(int id, String name, String username, String password, int roleid,long managerid) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
		this.managerid = managerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public long getManagerid() {
		return managerid;
	}

	public void setManagerid(long managerid) {
		this.managerid = managerid;
	}

//	public List<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(List<Project> projects) {
//		this.projects = projects;
//	}

	public List<FeedbackEmp> getFeedbackEmps() {
		return feedbackEmps;
	}

	public void setFeedbackEmps(List<FeedbackEmp> feedbackEmps) {
		this.feedbackEmps = feedbackEmps;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", roleid="
				+ roleid + ", managerid=" + managerid + "]";
	}
}