package com.app.surveyquestionire.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	public List<User> findByaddressCountry(String country);
	
	public List<User> findByaddressCountryAndSalaryGreaterThanEqual(String country,Integer salary);
	
	public List<User> findBySalaryLessThanEqualOrAgeLessThanEqual(int sal,double age);
	
	public List<User> findByAgeBetween(double stage,double edage);
	
	public List<User> findByUnameLike(String name);
	
	public List<User> findBySalaryGreaterThanOrderByUidAsc(int sal);

}
