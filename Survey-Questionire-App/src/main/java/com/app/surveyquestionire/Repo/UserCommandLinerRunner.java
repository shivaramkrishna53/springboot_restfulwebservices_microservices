package com.app.surveyquestionire.Repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.surveyquestionire.dao.DaoImpl;

@Repository
@Transactional
public class UserCommandLinerRunner implements CommandLineRunner {
	
	@PersistenceContext
	EntityManager entitymanager;
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	CustRepo custrepo;
	
	@Autowired
	DaoImpl dao;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	    User u1=new User("shiva",23.5,"india", 100000,2);
	    User u2=new User("sai",21.5,"usa", 200000,1);
	    User u3=new User("roopesh",18.0,"india",300000,0);
	    User u4=new User("varu",16.5,"africa", 400000,1);
	    User u5=new User("rekha",50.5,"australia", 600000,10);
	    User u6=new User("dpl",60.9,"australia", 1000000,15);
	    
	    Iterable<User> useritr=Arrays.asList(u1,u2,u3,u4,u5,u6);
	    
	    repo.saveAll(useritr);
		System.out.println("====fetching results from db::");
		System.out.println("---------l1");
		System.out.println(repo.count());
		repo.delete(u1);
		repo.deleteById(u2.getUid());
		System.out.println("---------l2");
		System.out.println(repo.existsById(u1.getUid()));
		Iterable<User> useriter=Arrays.asList(u1,u2);
		repo.saveAll(useriter);
		List<User> lstusers=(List<User>) repo.findAll();
		
		
		for(User w:lstusers)
		{
			System.out.println("=================");
			System.out.println(w.toString());
			System.out.println("=================");
		}
		
		//repo.deleteAll();
		repo.deleteAllById(Arrays.asList(new Integer[] {7,8}));
		System.out.println("---------l3");
		System.out.println(repo.count());
		
		List<User> countryusers=repo.findByaddressCountry("india");
		
		countryusers.stream().forEach(x->System.out.println(x.toString()));
		
		System.out.println("=================");
		
		List<User> lstconsal=repo.findByaddressCountryAndSalaryGreaterThanEqual("australia",700000);	
		lstconsal.stream().forEach(System.out::println);
		System.out.println("=================");
		List<User> lstsalage= repo.findBySalaryLessThanEqualOrAgeLessThanEqual(500000,60);
		
		//just using iterator inorder to loop through the list
		
		Iterator<User> itr=lstsalage.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next().toString());
		System.out.println("=================>");
		
		repo.findByUnameLike("r%").forEach(System.out::println);
		
		System.out.println("==============");
		
		repo.findBySalaryGreaterThanOrderByUidAsc(350000).forEach(System.out::println);
		
		//open transactional
		 User u7=new User("ram",23.5,"india", 300000,5);
		 entitymanager.persist(u7);
		 u7.setAddressCountry("dubai");
		 User u8=new User("raju",23.5,"australia", 300000,5);
		 u8.setAddressCountry("goa");
		//close transcational
		
		dao.insertUser(u8);
		
		 System.out.println("=======>");
		 repo.findAll().forEach(System.out::println);
		 System.out.println("----????");
		 Customer c1=new Customer();
		 c1.setCname("jai");
		 custrepo.save(c1);
		 custrepo.findAll().forEach(System.out::println);
	}
	

}
