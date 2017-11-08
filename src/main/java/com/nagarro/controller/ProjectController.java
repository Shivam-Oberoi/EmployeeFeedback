package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.model.EmpFeedback;
import com.nagarro.model.Project;
import com.nagarro.service.ProjectService;

@Controller
@RequestMapping("project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/userProjects/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Project> getProjects(@PathVariable(name="id") Integer id, HttpSession httpSession) {
		httpSession.setAttribute("feedbackEmpId", id);
		System.out.println("id:"+id);
		return projectService.findProjects(id);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public @ResponseBody List<EmpFeedback> getEmployees(@PathVariable(name="id") Integer projectid, HttpSession httpSession) {
		Integer userId = (Integer) httpSession.getAttribute("feedbackEmpId");
		return projectService.findProjectEmps(projectid, userId);
	}
	
	@RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
	public @ResponseBody List<EmpFeedback> getManagerProjectEmployees(@PathVariable(name="id") Integer projectid, HttpSession httpSession) {
		Integer managetId = (Integer) httpSession.getAttribute("feedbackEmpId");
		return projectService.findProjectManagerEmps(projectid, managetId);
	}
	
	
}