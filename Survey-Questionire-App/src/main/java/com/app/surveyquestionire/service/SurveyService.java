package com.app.surveyquestionire.service;

import java.util.List;

import com.app.surveyquestionire.model.Question;
import com.app.surveyquestionire.model.Survey;

public interface SurveyService {
	
	public Survey retrivesurvey(String surveyid);
	public List<Question> retriveAllQuestionsofaSurvey(String surveyid);
	public Question retriveQuestion(String surveyid,String questionid);
	public Question addAQuestion(String surveyid,Question q);
	

}
