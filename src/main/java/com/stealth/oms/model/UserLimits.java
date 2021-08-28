package com.stealth.oms.model;


public class UserLimits {
	private int minimum;
	private int maximum;
	
	public UserLimits() {
		super();
	}

	public UserLimits(int maximum, int minimum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	public int getMinimum() {
		return minimum;
	}
	
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	public int getMaximum() {
		return maximum;
	}
	
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}
