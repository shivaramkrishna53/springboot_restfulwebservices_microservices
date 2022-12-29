package com.nt.microservices.currencyexchange.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CurrencyExchange {
	
	@Id
	private long id;
	@Column(name="from_currency")
	private String from;
	@Column(name="to_currency")
	private String to;
	private long conversionMultiple;
	private String environment;
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(long id, String from, String to, long conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public long getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(long conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + "]";
	}
	
	
	

}
