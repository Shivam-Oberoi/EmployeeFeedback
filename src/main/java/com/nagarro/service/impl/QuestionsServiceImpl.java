package com.nagarro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.Answers;
import com.nagarro.model.Feedback;
import com.nagarro.model.FeedbackEmp;
import com.nagarro.model.Questions;
import com.nagarro.repository.FeedbackRepository;
import com.nagarro.repository.QuestionsRepository;
import com.nagarro.service.QuestionsService;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	
	@Autowired
	QuestionsRepository questionsRepository;
	
	@Autowired
	FeedbackRepository feedbackRepostory;

	@Override
	public List<Questions> findAll() {
		return questionsRepository.findAll();
	}

	@Override
	public String submitFeedback(Integer empId, long id, Answers answers) {
		return questionsRepository.submitFeedback(empId, id, answers);
	}

//	@Override
//	public Map<Long, List<Feedback>> findFeedbackById(Integer id) {
//		return questionsRepository.findFeedbackById(id);
//	}
	
	@Override
	public List<Feedback> findFeedbackById(Integer id) {
		return questionsRepository.findFeedbackById(id);
	}

	@Override
	public FeedbackEmp getEmpfeedback(Integer id, Integer userId) {
		FeedbackEmp feedbackEmp = feedbackRepostory.findByToidAndUserid(id, userId);
		System.out.println(feedbackEmp);
		return feedbackEmp;
	}

	@Override
	public List<FeedbackEmp> getEmpsfeedback(Integer id) {
		return feedbackRepostory.findByToid(id);
	}

}
