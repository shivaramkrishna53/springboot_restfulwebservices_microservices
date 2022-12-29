package com.nt.microservices.currencyconversion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nt.microservices.currencyconversion.dto.CurrencyExchange;
import com.nt.microservices.currencyconversion.service.CurrencyExchageProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchageProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyExchange getCurrencyConverted(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") String quantity) {
		int quant = Integer.parseInt(quantity);
		
		Map<String,String> mp=new HashMap<>();
		mp.put("from", from);
		mp.put("to", to);

		ResponseEntity<CurrencyExchange> response=new RestTemplate().getForEntity("http://localhost:8120/currencyexchange/from/{from}/to/{to}",CurrencyExchange.class,mp);
	
		CurrencyExchange currencyexchange=response.getBody();
		currencyexchange.setQuantity(quant);
		currencyexchange.setTotalCalculatedAmount(quant * currencyexchange.getConversionMultiple());
		return currencyexchange;
	}
	
	@GetMapping("/currency-conversionfeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyExchange getCurrencyConvertedByFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") String quantity) {
		int quant = Integer.parseInt(quantity);
		CurrencyExchange currencyexchange=proxy.converter(from, to);
		currencyexchange.setQuantity(quant);
		currencyexchange.setTotalCalculatedAmount(quant * currencyexchange.getConversionMultiple());
		return currencyexchange;
	}

}
