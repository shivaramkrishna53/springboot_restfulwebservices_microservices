package com.nt.microservices.currencyexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.microservices.currencyexchange.dto.CurrencyExchange;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Integer>{
       public CurrencyExchange findByFromAndTo(String from,String to);

}
