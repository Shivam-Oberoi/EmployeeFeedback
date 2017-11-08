package com.nagarro.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class FeedbackEmp {

	@Id
	private int id;
	private String feedback;
	
//	@Column(name="ques_id")
	@ManyToOne
	@JoinColumn(name = "ques_id")
	private Questions questionid;
	
	@ManyToOne
	@JoinColumn(name = "to_id")
	private User toid;
	
//	@Column(name="user_id")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userid;
	
	private int rating;
	@Transient
	Date startdate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return feedback;
	}
	public void setAnswer(String answer) {
		this.feedback = answer;
	}
	public Questions getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Questions questionid) {
		this.questionid = questionid;
	}
	
	public User getToid() {
		return toid;
	}
	public void setToid(User toid) {
		this.toid = toid;
	}
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "FeedbackEmp [id=" + id + ", feedback=" + feedback + ", questionid=" + questionid + ", toid=" + toid
				+ ", userid=" + userid + ", rating=" + rating + ", startdate=" + startdate + "]";
	}
	
}
