package com.app.surveyquestionire.Repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	
	private String uname;
	
	private Double age;
	
	private String addressCountry;
	
	private Integer salary;
	
	private Integer yearsofexp;
	
	public User() {}

	public User(String uname, Double age, String addressCountry, Integer salary, Integer yearsofexp) {
		super();
		
		this.uname = uname;
		this.age = age;
		this.addressCountry = addressCountry;
		this.salary = salary;
		this.yearsofexp = yearsofexp;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getYearsofexp() {
		return yearsofexp;
	}

	public void setYearsofexp(Integer yearsofexp) {
		this.yearsofexp = yearsofexp;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", age=" + age + ", addressCountry=" + addressCountry
				+ ", salary=" + salary + ", yearsofexp=" + yearsofexp + "]";
	}
	
	

	
	
}
