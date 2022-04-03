package com.in28mins.webservices.webservicesproj1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.webservices.webservicesproj1.dto.Users;

@RestController
public class DemoController {
	
	@GetMapping("/show")
	public String m1()
	{
	return "happyholi";	
	}
	
	@PostMapping("/user")
	public Users m2(@RequestBody Users u)
	{
		return u;
	}
	
	@GetMapping("/users/{userid}")
	public Users getUser(@PathVariable String userid)
	{
		int uid=Integer.parseInt(userid);
		return new Users(uid);
	}

}
