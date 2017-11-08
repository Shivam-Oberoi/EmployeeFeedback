package com.nagarro.model;

import java.math.BigInteger;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

@Entity
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = "saveFeedbackSP", procedureName = "dbo.saveFeedback ", parameters = {
				@StoredProcedureParameter(name = "UserId", mode = ParameterMode.IN, type = Long.class),
				@StoredProcedureParameter(name = "EmpId", mode = ParameterMode.IN, type = Integer.class),
				@StoredProcedureParameter(name = "Ans", mode = ParameterMode.IN, type = String.class),
				@StoredProcedureParameter(name = "QuesId", mode = ParameterMode.IN, type = Integer.class),
				@StoredProcedureParameter(name = "FeedbackNo", mode = ParameterMode.IN, type = BigInteger.class),
				@StoredProcedureParameter(name = "Result", mode = ParameterMode.OUT, type = String.class)})
		})
public class Answers {
	@Id
	long id;
	String text;
	@Transient
	Map<String, String> answerMap;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, String> getAnswerMap() {
		return answerMap;
	}

	public void setAnswerMap(Map<String, String> answerMap) {
		this.answerMap = answerMap;
	}

}
