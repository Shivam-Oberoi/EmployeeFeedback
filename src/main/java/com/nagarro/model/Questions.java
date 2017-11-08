package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

@Entity
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = "findAllQuestionsSP", procedureName = "dbo.findAllQuestions ", resultClasses = { Questions.class })
		})
public class Questions {

	@Id
	private int id;
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
