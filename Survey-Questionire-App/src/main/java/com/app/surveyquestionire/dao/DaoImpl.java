package com.app.surveyquestionire.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.surveyquestionire.Repo.User;

@Repository
@Transactional
public class DaoImpl {
	
	@PersistenceContext
	EntityManager entityman;
	
	public void insertUser(User u)
    {
		entityman.persist(u);
	}
	
	public void deleteUser(User u)
	{
		entityman.remove(u);
	}
	
	public void updateUser(User u)
	{
		entityman.merge(u);
	}
}

/*
 * @Repository
public class DaoImpl {
	
	@PersistenceContext
	EntityManager entityman;
	
	public void insertUser(Customer u)
	{
		entityman.persist(u);
	}
	
	public void deleteUser(Customer u)
	{
		entityman.remove(u);
	}
}
 */
