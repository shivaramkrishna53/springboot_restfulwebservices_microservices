package com.in28min.springboot.springbootproj1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in28min.springboot.springbootproj1.dto.ToDoInfo;

public interface TodoRepo extends JpaRepository<ToDoInfo,Integer> {
	
	@Query("select td from ToDoInfo td where td.user.id=?1")
	public List<ToDoInfo> findByForiegnKey(Integer id);

	
	public ToDoInfo findByUsernameAndCourses(String username,String courses);
	
	
	public void deleteByCoursesAndUsername(String courses,String username);
}
