package com.socialmedia.app.repo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.dtos.Users;

@Repository
public class PersonRepo {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private static String select_query="select * from users where uid=? ";
	private static String insert_query="insert into users(uid,uemailid,uname,upass,ustatus) values (?,?,?,?,?)";
			
	public Users getAllUsers(int id)
	{
		//row mapper--> convert each row-->bean
		
		return jdbctemplate.queryForObject(select_query,new BeanPropertyRowMapper<>(Users.class),id);
	}
	
	public int insertAUser(Users user)
	{
		return jdbctemplate.update(insert_query,new Random().nextInt(),user.getUemailid(),user.getUname(),"123","active");
	}

}
