package com.in28min.springboot.springbootproj1.service;

import java.util.List;

import com.in28min.springboot.springbootproj1.dto.ToDoInfo;
import com.in28min.springboot.springbootproj1.dto.User;

public interface IToDoService {
	
	public void savesignindetails(User user);
	
	public int validateloginofuser(String username,String password);
	
	
	public String getcurrentdaystatus();
	
	
	public void todosave(ToDoInfo todo);
	
	public void todeleteatodo(String[] courses,String user);
	
	public List<ToDoInfo> toretrivetodo(String username);
	
	public void modifytodo(ToDoInfo todo);

}
