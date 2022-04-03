package com.app.surveyquestionire.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.surveyquestionire.SurveyQuestionireAppApplication;
import com.app.surveyquestionire.model.Question;


@RunWith(SpringRunner.class)
@SpringBootTest(classes =SurveyQuestionireAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyControllerIT {
	
	@LocalServerPort
	public int serverport;

	@Test
	void test() throws JSONException {
		
		System.out.println("Port"+serverport);
		
		String url="http://localhost:"+String.valueOf(serverport)+"/survey/survey1/question/question1";
		
		System.out.println(url);
		
		TestRestTemplate resttemp=new TestRestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity requestEntity=new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> result=resttemp.exchange(url,HttpMethod.GET, requestEntity, String.class);
		System.out.println("----------result------");
		System.out.println(result.getBody());

//		
		String expec="{id:  101 ,name:  shiva,company:tcs }";
		String actu="{id:101,name:shiva,company:tcs}";
		
		JSONAssert.assertEquals(expec, actu, true);
		
		String ex="{\"questionid\":\"question1\",\"questiondescription\":\"How many continents are there in world\"}";
		//System.out.println(ex);
		System.out.println("======");
		System.out.println(result.getBody());
		JSONAssert.assertEquals(ex, result.getBody(),false);
		
	}
	
	@Test
	public void testpostmethodcall()
	{
		
		String url="http://localhost/"+serverport+"/survey/survey1/addquestion";
		System.out.println(url);
		
		TestRestTemplate restemplate=new TestRestTemplate();
		Question q=new Question("randomquestion", "How many Oceans are there in world", "4", Arrays.asList("1","7","4","10"));
		
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		
		HttpEntity requestEntity=new HttpEntity<Question>(q,headers);
		
		
		
		ResponseEntity<String> response=restemplate.exchange(url,HttpMethod.POST, requestEntity,String.class);
		System.out.println(response);
		
		System.out.println("<--->");
		System.out.println(response.getHeaders());
		String result=response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		
	}
	

}
