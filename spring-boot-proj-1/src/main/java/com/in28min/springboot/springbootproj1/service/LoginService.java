package com.in28min.springboot.springbootproj1.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public static Map<String,String> userscredentials=new HashMap<String, String>();
	
	static
	{
		userscredentials.put("shiva","shiva1234");
		userscredentials.put("sai","sai1234");
	}
	
	public boolean validatecredentials(String username,String password)
	{
		if(username.equalsIgnoreCase("shiva ram krishna durgi")  && password.equals("shiva1234"))
              return true;
		else
			return false;
		
	}
	
	public String adduser(String username,String password)
	{
		userscredentials.put(username, password);
		return username;
	}

}
