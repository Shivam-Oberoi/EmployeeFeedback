package com.nagarro.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {

	@Id
	private int id;
	private String name;
//	@OneToMany(mappedBy = "projects")
//	@JsonIgnore 
//	private List<User> users;
	@OneToMany(mappedBy="projectid", fetch = FetchType.EAGER, orphanRemoval = true)
	List <ProjectEmpMap> projectEmpMaps;
	
	
	public Project() {
		
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
	public List<ProjectEmpMap> getProjectEmpMaps() {
		return projectEmpMaps;
	}
	public void setProjectEmpMaps(List<ProjectEmpMap> projectEmpMaps) {
		this.projectEmpMaps = projectEmpMaps;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", projectEmpMaps=" + projectEmpMaps + "]";
	}
	
//	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

}
