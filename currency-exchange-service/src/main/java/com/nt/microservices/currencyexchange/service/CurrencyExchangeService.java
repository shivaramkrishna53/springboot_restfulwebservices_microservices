package com.nt.microservices.currencyexchange.service;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
	
	public int getthecurrencyamount(String from,String to)
	{
		if(from.equals("USD"))
		{
			switch (to) {
			case "INR":
				return 75;
			case "EUR":
				return 65;
			case "DUB":
				return 25;
			default:
				return 1;
			}
		}
		else if(from.equals("EUR"))
		{
			switch (to) {
			case "USD":
				return 1;
			case "HKD":
				return 7;
			case "INR":
				return 84;
			default:
				return 1;
			}
			
		}
		else
		{
			return 100;
		}
		
	}

}
