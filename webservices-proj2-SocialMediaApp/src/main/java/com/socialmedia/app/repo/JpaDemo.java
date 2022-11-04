package com.socialmedia.app.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.dtos.Users;

@Repository
@Transactional
public class JpaDemo {
	
	@Autowired
	EntityManager entitymanger;
	
	public Users findUserById(int id)
	{
		return entitymanger.find(Users.class,id);
	}
	
	public Users saveUser(Users user)
	{
		return entitymanger.merge(user);
	}
	
	public Users deleteUser(int id)
	{
		Users user=entitymanger.find(Users.class,id);
		entitymanger.remove(user);
		return user;
	}
	
	

}
