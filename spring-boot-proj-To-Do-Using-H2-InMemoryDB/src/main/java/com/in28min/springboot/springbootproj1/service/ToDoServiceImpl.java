package com.in28min.springboot.springbootproj1.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28min.springboot.springbootproj1.dto.ToDoInfo;
import com.in28min.springboot.springbootproj1.dto.User;
import com.in28min.springboot.springbootproj1.repo.TodoRepo;
import com.in28min.springboot.springbootproj1.repo.UsersRepo;

@Service
public class ToDoServiceImpl implements IToDoService {

	public  List<User> signinDetailsList=new ArrayList<User>();
	
	public Map<String,List<ToDoInfo>> todomap=new HashMap<String, List<ToDoInfo>>();
	
	List<ToDoInfo> lst;
	
	@Autowired
	UsersRepo repo;
	
	@Autowired
	TodoRepo tdrepo;
	
	
	@Override
	public void savesignindetails(User user) {
		// TODO Auto-generated method stub
		
		repo.save(user);
//		signinDetailsList.add(user);
//		System.out.println("size is:"+signinDetailsList.size());

	}

	@Override
	public int validateloginofuser(String username, String password) {
		// TODO Auto-generated method stub
		
		User u=repo.findByName(username);
		if(u==null)
			return 0;
		else
		{
			if(u.getPassword1().equals(password))
				return 5;
			else
				return 1;
		}
		
		
//		int flag=0;
//		for(User user:signinDetailsList)
//		{
//			if(user.getName().equals(username))
//				flag++;
//			
//			if(user.getName().equals(username) && user.getPassword1().equals(password))
//			return 5;	
//			
//		}
//		if(flag>0)
//			return 1;
//		else
//			return 0;
		
		
	}

	@Override
	public String getcurrentdaystatus() {
		// TODO Auto-generated method stub
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		int hrs=now.getHour();
		if(hrs>0 && hrs<12)
			return "Good Morning";
		else if (hrs>12 && hrs<16)
			return "Good Afternoon";
		else if(hrs>16 && hrs<20)
			return "Good Evening";
		else
			return "Good Night";
	
	}

	@Override
	public void todosave(ToDoInfo todo) {
		// TODO Auto-generated method stub
		
//	    if(todomap.get(todo.getUsername())!=null)
//		todomap.get(todo.getUsername()).add(todo);
//	    else {
//	    	List<ToDoInfo> lst=new ArrayList<ToDoInfo>();
//	    	lst.add(todo);
//	    	todomap.put(todo.getUsername(),lst);
//	    	}
		
		User u=repo.findByName(todo.getUsername());
		u.getTodos().add(todo);
		repo.save(u);
		todo.setUser(u);
		tdrepo.save(todo);
		
	}

	@Override
	@Transactional
	public void todeleteatodo(String[] courses,String user) {
		// TODO Auto-generated method stub
//		System.out.println(user);
//		List<ToDoInfo> lst=todomap.get(user);
//		System.out.println("==================");
//		System.out.println(courses[0]);
//		System.out.println(courses[1]);
//		System.out.println("==============");
//		for(ToDoInfo x:lst)
//		{
//			System.out.println("***"+x.toString());
//			if(x.getCourses().equals(courses[0]) || x.getCourses().equals(courses[1]) )
//			{
//				System.out.println("inside if");
//				lst.remove(x);
//			}
//		}
//		todomap.put(user, lst);
		
		for(String course:courses)
			tdrepo.deleteByCoursesAndUsername(course,user);
		
	}

	@Override
	public List<ToDoInfo> toretrivetodo(String username) {
		// TODO Auto-generated method stub
		//return todomap.get(username);
		List<ToDoInfo> res=tdrepo.findByForiegnKey(repo.findByName(username).getId());
		return res;
	}

	@Override
	public void modifytodo(ToDoInfo todo) {
		// TODO Auto-generated method stub
		
//		List<ToDoInfo> lst=todomap.get(todo.getUsername());
//		for(int i=0;i<lst.size();i++)
//		{
//			ToDoInfo x=lst.get(i);
//			if(todo.getCourses().equals(x.getCourses()))
//			{
//				System.out.println("inside if"+x.getCourses()+" "+todo.getCourses());
//				x.setDate(todo.getDate());
//				x.setPriority(todo.getPriority());
//				lst.set(i, x);
//			}
//			
//		}
//		todomap.put(todo.getUsername(),lst);
//		System.out.println(lst);
//		System.out.println(todomap);
		
		ToDoInfo td=tdrepo.findByUsernameAndCourses(todo.getUsername(),todo.getCourses());
		td.setDate(todo.getDate());
		td.setPriority(todo.getPriority());
		tdrepo.save(td);
	}
	
	

}
