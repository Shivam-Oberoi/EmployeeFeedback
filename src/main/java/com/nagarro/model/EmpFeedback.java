package com.nagarro.model;

public class EmpFeedback {
	
	private User user;
	private Integer rating;
	
	public EmpFeedback() {
		
	}
	
	public EmpFeedback(User user, Integer rating) {
		super();
		this.user = user;
		this.rating = rating;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "EmpFeedback [user=" + user + ", rating=" + rating + "]";
	}
	
	
}
