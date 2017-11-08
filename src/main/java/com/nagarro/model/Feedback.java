package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {

	@Id
	int id;
	String answer;
	String question;
	Integer rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [answer=" + answer + ", question=" + question + ", rating=" + rating + "]";
	}

}
