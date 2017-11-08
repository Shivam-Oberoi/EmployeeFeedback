package com.nagarro.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nagarro.model.Answers;
import com.nagarro.model.Feedback;
import com.nagarro.model.FeedbackEmp;
import com.nagarro.model.Questions;

@Service
public interface QuestionsService{

	List<Questions> findAll();

	String submitFeedback(Integer empId, long id, Answers answers);

//	Map<Long, List<Feedback>> findFeedbackById(Integer id);
	
	List<Feedback> findFeedbackById(Integer id);

	FeedbackEmp getEmpfeedback(Integer id, Integer userId);

	List<FeedbackEmp> getEmpsfeedback(Integer id);
}
