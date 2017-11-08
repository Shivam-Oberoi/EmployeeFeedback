package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.model.Login;
import com.nagarro.model.User;
import com.nagarro.service.ProjectService;
import com.nagarro.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession httpSession, @ModelAttribute("user") User user, ModelMap modelMap) {
		Login loginUser = userService.findByUsername(user);
		String jsp = "index";
		String message = "";
		if (loginUser != null) {
			jsp = loginUser.getJsp();
			message = loginUser.getMessage();
//			projectService.findAll((int) loginUser.getUser().getId());
//			List<User> employeeList = userService.findByManagerId(loginUser.getUser());
			httpSession.setAttribute("user", loginUser.getUser());
//			modelMap.addAttribute("user", loginUser.getUser());
//			modelMap.addAttribute("employeeList", employeeList);
			System.out.println("Message:"+message);
		}
		modelMap.addAttribute("message", message);
		return jsp;
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(HttpSession httpSession, @ModelAttribute("user") User user, ModelMap modelMap) {
//		Login loginUser = userService.findByUsername(user);
//		String jsp = "index";
//		String message = "";
//		if (loginUser != null) {
//			jsp = loginUser.getJsp();
//			message = loginUser.getMessage();
////			List<User> employeeList = userService.findByManagerId(loginUser.getUser());
//			httpSession.setAttribute("user", loginUser.getUser());
////			modelMap.addAttribute("user", loginUser.getUser());
////			modelMap.addAttribute("employeeList", employeeList);
//			System.out.println("Message:"+message);
//		}
//		modelMap.addAttribute("message", message);
//		return jsp;
//	}
	
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
		
	}
}