package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.model.FeedbackEmp;

public interface FeedbackRepository extends JpaRepository<FeedbackEmp, Integer> {
	
	FeedbackEmp findByToidAndUserid(Integer id, Integer userid);
	
	List<FeedbackEmp> findByToid(Integer id);

}
