package com.nt.microservices.currencyconversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.microservices.currencyconversion.dto.CurrencyExchange;


//@FeignClient(name="currency-exchange-service",url = "localhost:8120")
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchageProxy {
	
	@GetMapping("/currencyexchange/from/{from}/to/{to}")
	public CurrencyExchange converter(@PathVariable("from") String from,@PathVariable("to") String to);
	

}
