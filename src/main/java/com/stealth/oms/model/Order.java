package com.stealth.oms.model;

public class Order {

	private String message;
	
	public Order(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
		
	public String getMessage() {
		return this.message;
	}
	
}
