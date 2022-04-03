package com.in28min.springboot.springbootproj1.dto;

import java.util.Date;

public class ToDoInfo {

	private String courses;
	private String date;
	private Integer priority;
	private String username;
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ToDoInfo [courses=" + courses + ", date=" + date + ", priority=" + priority + ", username=" + username
				+ "]";
	}
}
