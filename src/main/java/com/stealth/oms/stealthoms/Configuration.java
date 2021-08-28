package com.stealth.oms.stealthoms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("stealth-oms")
public class Configuration {
	private int minimum;
	private int maximum;
	
	public Configuration() {
		super();
	}

	public Configuration(int maximum, int minimum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}	
	
	public int getMaximum() {
		return this.maximum;
	}
	
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	public int getMinimum() {
		return this.minimum;
	}
	
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
}
