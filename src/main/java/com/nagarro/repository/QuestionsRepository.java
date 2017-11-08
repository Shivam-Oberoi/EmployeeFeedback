package com.nagarro.repository;

import java.util.List;
import java.util.Map;

import com.nagarro.model.Answers;
import com.nagarro.model.Feedback;
import com.nagarro.model.Questions;

public interface QuestionsRepository{

	List<Questions> findAll();

	String submitFeedback(Integer empId, long id, Answers answers);

//	Map<Long, List<Feedback>> findFeedbackById(Integer id);
	
	List<Feedback> findFeedbackById(Integer id);
}

