package com.app.surveyquestionire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SurveyQuestionireAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyQuestionireAppApplication.class, args);
		
	}
	
	@Profile("dev")
	@Bean("newbeanofspring")
	public String newbean()
	{
		return "xyz";
	}

}
