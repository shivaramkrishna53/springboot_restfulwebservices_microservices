package com.app.surveyquestionire.model;

import java.util.List;

public class Question {

	private String questionid;
	private String questiondescription;
	private String qcorrectanswer;
	private List<String> qoptions;
	public Question(String questionid, String questiondescription, String qcorrectanswer, List<String> qoptions) {
		super();
		this.questionid = questionid;
		this.questiondescription = questiondescription;
		this.qcorrectanswer = qcorrectanswer;
		this.qoptions = qoptions;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getQuestiondescription() {
		return questiondescription;
	}
	public void setQuestiondescription(String questiondescription) {
		this.questiondescription = questiondescription;
	}
	public String getQcorrectanswer() {
		return qcorrectanswer;
	}
	public void setQcorrectanswer(String qcorrectanswer) {
		this.qcorrectanswer = qcorrectanswer;
	}
	public List<String> getQoptions() {
		return qoptions;
	}
	public void setQoptions(List<String> qoptions) {
		this.qoptions = qoptions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qcorrectanswer == null) ? 0 : qcorrectanswer.hashCode());
		result = prime * result + ((qoptions == null) ? 0 : qoptions.hashCode());
		result = prime * result + ((questiondescription == null) ? 0 : questiondescription.hashCode());
		result = prime * result + ((questionid == null) ? 0 : questionid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (qcorrectanswer == null) {
			if (other.qcorrectanswer != null)
				return false;
		} else if (!qcorrectanswer.equals(other.qcorrectanswer))
			return false;
		if (qoptions == null) {
			if (other.qoptions != null)
				return false;
		} else if (!qoptions.equals(other.qoptions))
			return false;
		if (questiondescription == null) {
			if (other.questiondescription != null)
				return false;
		} else if (!questiondescription.equals(other.questiondescription))
			return false;
		if (questionid == null) {
			if (other.questionid != null)
				return false;
		} else if (!questionid.equals(other.questionid))
			return false;
		return true;
	}
	
	
}
