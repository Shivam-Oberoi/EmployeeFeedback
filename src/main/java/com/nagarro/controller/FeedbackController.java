package com.nagarro.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.model.Answers;
import com.nagarro.model.Feedback;
import com.nagarro.model.FeedbackEmp;
import com.nagarro.model.Questions;
import com.nagarro.model.User;
import com.nagarro.service.QuestionsService;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

	@Autowired
	QuestionsService questionsService;

	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Questions> getQuestions(@PathVariable(name="id") Integer id, HttpSession httpSession) {
		httpSession.setAttribute("feedbackEmpId", id);
		return questionsService.findAll();
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public @ResponseBody String submitFeedback(@RequestBody Answers  answers, HttpSession httpSession) {
		Integer empId = (Integer) httpSession.getAttribute("feedbackEmpId");
		User user = (User) httpSession.getAttribute("user");
		String result = questionsService.submitFeedback(empId, user.getId(), answers);
		return result;
	}
	
	@RequestMapping(value = "/submittedFeedback/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Feedback> getFeedback(@PathVariable(name="id") Integer id, HttpSession httpSession) {
		return questionsService.findFeedbackById(id);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody FeedbackEmp getEmpFeedback(@PathVariable(name="id") Integer id, HttpSession httpSession) {
		Integer userId = (Integer) httpSession.getAttribute("feedbackEmpId");
		return questionsService.getEmpfeedback(id,userId);
	}
	
	@RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
	public @ResponseBody List<FeedbackEmp> getEmpsFeedback(@PathVariable(name="id") Integer id, HttpSession httpSession) {
		return questionsService.getEmpsfeedback(id);
	}
	
}