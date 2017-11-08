package com.nagarro.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = "findFeedbackSP", procedureName = "dbo.findFeedbackById ", resultClasses = { Feedback.class },
				parameters = {
				@StoredProcedureParameter(name = "Id", mode = ParameterMode.IN, type = Integer.class),
				})
		})
public class QuestionAnswer {

	@Id
	long id;
	long answerid;
	long questionid;
	long toid;
	long fromid;
	long feedbackno;
	Date startdate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAnswerid() {
		return answerid;
	}

	public void setAnswerid(long answerid) {
		this.answerid = answerid;
	}

	public long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}

	public long getToid() {
		return toid;
	}

	public void setToid(long toid) {
		this.toid = toid;
	}

	public long getFromid() {
		return fromid;
	}

	public void setFromid(long fromid) {
		this.fromid = fromid;
	}

	public long getFeedbackno() {
		return feedbackno;
	}

	public void setFeedbackno(long feedbackno) {
		this.feedbackno = feedbackno;
	}

}
