package com.nt.microservices.currencyconversion.dto;

public class CurrencyExchange {
	
	private int id;
	private String from;
	private String to;
	private int quantity;
	private int conversionMultiple;
	private long totalCalculatedAmount;
	private String environment;
	
	public CurrencyExchange(int id, String from, String to, int quantity, int conversionMultiple,
			long totalCalculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	public CurrencyExchange() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(int conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public long getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(long totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	
}
