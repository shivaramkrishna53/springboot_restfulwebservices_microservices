package com.app.surveyquestionire.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("person")
public class PersonConfig {
	
	private String name;
	private int age;
	private boolean boolval;
	private float height;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isBoolval() {
		return boolval;
	}
	public void setBoolval(boolean boolval) {
		this.boolval = boolval;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	

}
