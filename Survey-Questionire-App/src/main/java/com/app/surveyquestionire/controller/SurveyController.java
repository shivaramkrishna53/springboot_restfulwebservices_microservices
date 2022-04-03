package com.app.surveyquestionire.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.surveyquestionire.config.PersonConfig;
import com.app.surveyquestionire.model.Question;
import com.app.surveyquestionire.service.SurveyService;

@RestController
public class SurveyController {
	
	@Value("${welcome.msg}")
	public String msg;
	
	@Value("${currentenv}")
	public String currentenv;
	
	@Value("${db.username}")
	public String dbusername;
	
	@Value("${db.password}")
	public String dbpassword;
	
	
	@Autowired
	SurveyService ser;
	
//	@Autowired
//	PersonConfig perconfig;
	
	@GetMapping("/survey/{surveyid}/questions")
	public List<Question> getAllQuestionsFromSurvey(@PathVariable String surveyid)
	{
		return ser.retriveAllQuestionsofaSurvey(surveyid);
	}
	
	
	@GetMapping("/survey/{surveyid}/question/{questionid}")
	public Question getQuestionDetails(@PathVariable String surveyid, @PathVariable String questionid)
	{
		return ser.retriveQuestion(surveyid, questionid);
	
	}
	
	@PostMapping("/survey/{surveyid}/addquestion")
	public ResponseEntity addQuestionToSurvey(@PathVariable String surveyid,@RequestBody Question question)
	{
		
		Question q=ser.addAQuestion(surveyid, question);
		if(q==null)
			return ResponseEntity.noContent().build();
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(q.getQuestionid()).toUri();
		
		
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/welcome")
	public String displaywelcomemessagefrompropertyfile()
	{
		return msg +"from the environment::"+currentenv+" db-username::"+dbusername+" db-password::"+dbpassword;
	}
	
//	@GetMapping("/person")
//	public PersonConfig getpersondetails()
//	{
//		return perconfig;
//	}
	
	

}
