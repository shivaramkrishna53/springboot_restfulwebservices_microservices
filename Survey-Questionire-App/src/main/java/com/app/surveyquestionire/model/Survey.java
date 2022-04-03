package com.app.surveyquestionire.model;

import java.util.List;

public class Survey {
	
	private String surveyid;
	private String surveytitle;
	private String surveydescription;
	private List<Question> surveyquestions;
	
	
	public Survey(String surveyid, String surveytitle, String surveydescription, List<Question> surveyquestions) {
		super();
		this.surveyid = surveyid;
		this.surveytitle = surveytitle;
		this.surveydescription = surveydescription;
		this.surveyquestions = surveyquestions;
	}
	
	
	
	public String getSurveyid() {
		return surveyid;
	}
	public void setSurveyid(String surveyid) {
		this.surveyid = surveyid;
	}
	public String getSurveytitle() {
		return surveytitle;
	}
	public void setSurveytitle(String surveytitle) {
		this.surveytitle = surveytitle;
	}
	public String getSurveydescription() {
		return surveydescription;
	}
	public void setSurveydescription(String surveydescription) {
		this.surveydescription = surveydescription;
	}
	public List<Question> getSurveyquestions() {
		return surveyquestions;
	}
	public void setSurveyquestions(List<Question> surveyquestions) {
		this.surveyquestions = surveyquestions;
	}



	@Override
	public String toString() {
		return "Survey [surveyid=" + surveyid + ", surveytitle=" + surveytitle + ", surveydescription="
				+ surveydescription + ", surveyquestions=" + surveyquestions + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((surveydescription == null) ? 0 : surveydescription.hashCode());
		result = prime * result + ((surveyid == null) ? 0 : surveyid.hashCode());
		result = prime * result + ((surveyquestions == null) ? 0 : surveyquestions.hashCode());
		result = prime * result + ((surveytitle == null) ? 0 : surveytitle.hashCode());
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
		Survey other = (Survey) obj;
		if (surveydescription == null) {
			if (other.surveydescription != null)
				return false;
		} else if (!surveydescription.equals(other.surveydescription))
			return false;
		if (surveyid == null) {
			if (other.surveyid != null)
				return false;
		} else if (!surveyid.equals(other.surveyid))
			return false;
		if (surveyquestions == null) {
			if (other.surveyquestions != null)
				return false;
		} else if (!surveyquestions.equals(other.surveyquestions))
			return false;
		if (surveytitle == null) {
			if (other.surveytitle != null)
				return false;
		} else if (!surveytitle.equals(other.surveytitle))
			return false;
		return true;
	}
	
	

}
