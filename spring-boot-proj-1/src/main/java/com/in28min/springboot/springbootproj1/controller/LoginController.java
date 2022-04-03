package com.in28min.springboot.springbootproj1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28min.springboot.springbootproj1.dummy.DummyService;
import com.in28min.springboot.springbootproj1.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	
	@RequestMapping("/login")
	public String loginMessage(@RequestParam String name,@RequestParam String age,ModelMap model)
	{
		model.put("name",name);
		model.put("age",age);
		return "login";
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.GET)   //by default if we don't specify the method hadle type it can handle get,post,put,delete
	public String SignInPage()
	{
		return "signin";
	}
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String WelcomePageAfterSignIn(@RequestParam String name,@RequestParam String password,ModelMap model)
	{
		System.out.println(name +"  "+password);
		
		if(service.validatecredentials(name, password))
		{
			model.put("name",name);
			return "welcome";
		}
		else
		{
			model.put("message","Invalid credentials entered try it again");
			return "signin";
		}
		
		
		
	}

}
