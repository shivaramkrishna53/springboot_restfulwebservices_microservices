package com.socialmedia.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.dtos.UserDetails;
import com.socialmedia.app.dtos.Users;


public interface SocialMediaUsersRepo extends JpaRepository<Users,Integer> {

	//List<Users> findByudetails_uname(String uname);
	
	public Users findByuname(String name);
	
	public Users findByuid(Integer id);
	
	
	public Users findByUnameAndUemailid(String uname,String uemailid);
   
}
