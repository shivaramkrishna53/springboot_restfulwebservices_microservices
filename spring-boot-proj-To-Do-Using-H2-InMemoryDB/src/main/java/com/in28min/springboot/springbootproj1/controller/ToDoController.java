package com.in28min.springboot.springbootproj1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28min.springboot.springbootproj1.dto.ToDoInfo;
import com.in28min.springboot.springbootproj1.dto.User;
import com.in28min.springboot.springbootproj1.service.ToDoServiceImpl;

@Controller
//@SessionAttributes("emailid")
@SessionAttributes(value = {"username","emailid"})
public class ToDoController {
	
	
	
	@Autowired
	ToDoServiceImpl todoser;

	@RequestMapping(value = "/welcomepage",method = RequestMethod.GET)
	public String welcomepage()
	{
		return "welcome";
	}
	
	
	@RequestMapping("/signinpage")
	public String signinpage()
	{
	    return "signin";	
	}
	
	@RequestMapping(value="/loginpage",method = RequestMethod.GET)
	public String loginpage()
	{
		return "login";
	}
	
//	//@RequestMapping(value = "/signup", method = RequestMethod.POST)
//	@PostMapping(value="/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String SignUpUserDetails(@RequestBody User user)
//	{
//		System.out.println(user.getEmail());
//		return "todopage";
//	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String SignUpUserDetails(@ModelAttribute("usermodelatt") User user,ModelMap model)
	{
		if(user.getPassword1().equals(user.getPassword2()))
		{
			todoser.savesignindetails(user);
			model.put("result", "successfully signed up with user "+ user.getName());
			model.put("emailid", user.getEmail());
			return "login";
		}
		else
		{
			model.put("result","Make sure the password and confirm password are correct");
			return "signin";
		}
		
		
		
	}
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String LoginCheckup(@RequestParam String username,@RequestParam String password,ModelMap model)
	{
		System.out.println(username +"   "+password);
		int res=todoser.validateloginofuser(username, password);
		if(res==5)
		{
			String status=todoser.getcurrentdaystatus();
			
		model.put("result",status+" "+username+" Welcome to To-Do Menu");
		model.put("username",username);
		return "todo";
		}
		else
		{
			if(res==1)
			{
			model.put("result", "Username exists but password is wrong!!! try again");
			return "login";
			}
			else {
				model.put("result", "Username dosen't exist!!! Please signin");
				return "signin";
				
			}
		}
	}
	
	@RequestMapping(value = "/savetodos" , method = RequestMethod.POST)
	public String todosave(@ModelAttribute("todomodelatt") ToDoInfo todo,ModelMap model)
	{
		System.out.println(model.get("emailid"));
		System.out.println(todo.getUsername());
		System.out.println(todo.getDate());
		System.out.println(todo.getCourses());
		
		todoser.todosave(todo);
		model.put("username",todo.getUsername());
		return "successpage";
	}
	
	
	@GetMapping("/viewtodo/{username}")
	public String todisplaytodos(@PathVariable String username,ModelMap model)
	{
		List<ToDoInfo> todolst=todoser.toretrivetodo(username);
		model.put("username", username);
		model.put("todolst",todolst);
		
//		List<String> courseslst=new ArrayList<String>();
//		List<String> datelst=new ArrayList<String>();
//		List<Integer> prioritylst=new ArrayList<Integer>();
//		
//		for(ToDoInfo todo:todolst)
//		{
//			courseslst.add(todo.getCourses());
//			datelst.add(todo.getDate());
//			prioritylst.add(todo.getPriority());
//		}
//		model.put("courseslst",courseslst);
//		model.put("datelst", datelst);
//		model.put("prioritylst",prioritylst);
		return "displayexistingtodos";
	}
	
	
	@RequestMapping(value = "/addmoretodos/{username}",method = RequestMethod.GET)
	public String addtodostoexisting(ModelMap map,@PathVariable String username)
	{
		map.put("username", username);
		return "todo";
	}
	
	@RequestMapping(value="/modifyexistingtodos/{username}",method = RequestMethod.GET)
	public String modifyexistingtodo(@PathVariable String username, ModelMap map)
	{
		List<String> courseslst=new ArrayList<String>();
		List<ToDoInfo> todolst=todoser.toretrivetodo(username);
		
		for(ToDoInfo todo:todolst)
		courseslst.add(todo.getCourses());
		
		
		map.put("courseslst", courseslst);
		
		return "modifytodopage";
		
	}
	
	@RequestMapping(value="/modifyandsavetodo/{username}" ,method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
	public String modifyandsavetodo(@PathVariable String username,ToDoInfo todo)
	{
		System.out.println("========================");
		System.out.println(todo.toString());
		System.out.println("========================");
		todoser.modifytodo(todo);
		return "successpage";
	}
	
	@GetMapping("/deleteexistingtodos/{username}")
	public String gotodeltepage(@PathVariable String username,ModelMap map)
	{
		List<String> courseslst=new ArrayList<String>();
		List<ToDoInfo> todolst=todoser.toretrivetodo(username);
		
		for(ToDoInfo todo:todolst)
		courseslst.add(todo.getCourses());
		map.put("courseslst", courseslst);
		
		return "tododelete";
	}
	
	@PostMapping("/deletetodofromlist")
	public String deletetodofromlist(@RequestParam String[] checkboxed,ModelMap map)
	{
		for(String x:checkboxed)
		System.out.println(x);
		
		todoser.todeleteatodo(checkboxed,(String)map.get("username"));
		return "redirect:/successpage";
	}
	
	@RequestMapping("/successpage")
	public String dummy(ModelMap map)
	{
		List<ToDoInfo> todolst=todoser.toretrivetodo((String)map.get("username"));
		map.put("res", todolst);
		return "successpage";
	}
	
	
}
