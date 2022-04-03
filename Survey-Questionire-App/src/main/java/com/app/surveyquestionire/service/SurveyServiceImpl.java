package com.app.surveyquestionire.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.surveyquestionire.model.Question;
import com.app.surveyquestionire.model.Survey;

@Service
public class SurveyServiceImpl implements SurveyService {
	static List<Survey> surveylst=new ArrayList<Survey>();
	
	static
	{
	    
		Question q1=new Question("question1", "How many continents are there in world", "7", Arrays.asList("1","7","4","10"));
		Question q2=new Question("question2", "Who is our prime minsiter", "Narender Modi", Arrays.asList("kcr","pratiba patel","Narender Modi","Karuna Nedhi"));
		Question q3=new Question("question3", "Worlds largest country", "russia", Arrays.asList("russia","india","usa","china"));
		List<Question> lstques=new ArrayList<Question>(Arrays.asList(q1,q2,q3));
		Survey s1=new Survey("survey1", "General Knowldge", "General Knowldge Questions",lstques);
		surveylst.add(s1);
	}
	
	@Override
	public Survey retrivesurvey(String surveyid) {
		// TODO Auto-generated method stub
		
		if(surveyid==null)
			return null;
		
			for(Survey sur:surveylst)
			{
				if(sur.getSurveyid().equals(surveyid))
					return sur;
			}
			
			return null;
		
		
		
	}

	@Override
	public List<Question> retriveAllQuestionsofaSurvey(String surveyid) {
		// TODO Auto-generated method stub
		Survey sur=retrivesurvey(surveyid);
		if(sur!=null)
		return sur.getSurveyquestions();
		
		return null;
	}

	@Override
	public Question retriveQuestion(String surveyid, String questionid) {
		// TODO Auto-generated method stub
		Survey sur=retrivesurvey(surveyid);
		if(sur!=null) {
		for(Question q:sur.getSurveyquestions())
		{
			if(q.getQuestionid().equals(questionid))
				return q;
		}
		}
		return null;
	}

	@Override
	public Question addAQuestion(String surveyid, Question q) {
		// TODO Auto-generated method stub
		
		
		Survey sur=retrivesurvey(surveyid);
		
		if(sur==null)
			return null;
		
		int len=sur.getSurveyquestions().size();
		len++;
		q.setQuestionid("question"+(len));
		
		sur.getSurveyquestions().add(q);
		
		return q;

	}

	

}
