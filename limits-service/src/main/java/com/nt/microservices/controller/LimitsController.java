package com.nt.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.microservices.config.LimitsConfiguration;
import com.nt.microservices.dto.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	public LimitsConfiguration configuration;
	
	@GetMapping("/getlimits")
	public Limits getLimits()
	{
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
}
