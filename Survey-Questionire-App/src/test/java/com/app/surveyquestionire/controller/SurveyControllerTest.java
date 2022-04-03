package com.app.surveyquestionire.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.surveyquestionire.model.Question;
import com.app.surveyquestionire.service.SurveyServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTest {
	
	@MockBean
	SurveyServiceImpl ser;
	
	@Autowired
	MockMvc mvc;
	
		Question q=new Question("question1", "How many continents are there in world", "7", Arrays.asList("1","7","4","10"));
	
	
	
	@Test
	public void getQuestionDetailsTest() throws Exception
	{
	  Mockito.when(ser.retriveQuestion(Mockito.anyString(),Mockito.anyString())).thenReturn(q);
	  RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/survey/survey1/question/question1").accept(MediaType.APPLICATION_JSON);
	  MvcResult res=mvc.perform(requestBuilder).andReturn();
	  assertNotNull(res.getResponse());
	  String expected= "{\"questionid\":\"question1\",\"questiondescription\":\"How many continents are there in world\"}";
	  System.out.println("----------");
	  System.out.println(res.getResponse().getContentAsString());
	  System.out.println("----------");
	  JSONAssert.assertEquals(expected, res.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void addQuestionToSurveyTest() throws Exception
	{
		Mockito.when(ser.addAQuestion(Mockito.anyString(),Mockito.any(Question.class))).thenReturn(q);
		String jsonreq="{\"questionid\":\"question1\",\"questiondescription\":\"How many continents are there in world\",\"qcorrectanswer\":\"7\",\"qoptions\":[\"1\",\"7\",\"4\",\"10\"]}";
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/survey/survey1/addquestion").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonreq);
		MvcResult res=mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=res.getResponse();	
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
}
