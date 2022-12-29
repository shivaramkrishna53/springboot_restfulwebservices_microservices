package com.nt.microservices.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nt.microservices.currencyexchange.dto.CurrencyExchange;
import com.nt.microservices.currencyexchange.repo.CurrencyExchangeRepo;
import com.nt.microservices.currencyexchange.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeRepo repo;
	
	@Autowired
	CurrencyExchangeService service;
	
	@GetMapping("/currencyexchange/from/{from}/to/{to}")
	public CurrencyExchange converter(@PathVariable("from") String from,@PathVariable("to") String to)
	{
		
		int conversionmultiple=service.getthecurrencyamount(from, to);
		CurrencyExchange currencyExchange = new CurrencyExchange(123, from, to,conversionmultiple);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		repo.save(currencyExchange);
		return currencyExchange;
	}
	
	@GetMapping("/getbyfromto/{from}/{to}")
	public CurrencyExchange findbyfromandtoCurrency(@PathVariable("from") String from,@PathVariable("to") String to)
	{
		CurrencyExchange currencyExchange=repo.findByFromAndTo(from, to);
		return currencyExchange;
	}

}
