package com.in28min.springboot.springbootproj1.dto;

public class User {

	private String name;
	private String email;
	private Integer age;
	private String password1;
	private String password2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", password1=" + password1 + ", password2="
				+ password2 + "]";
	}
	
}
