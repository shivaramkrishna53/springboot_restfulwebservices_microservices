package com.in28min.springboot.springbootproj1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28min.springboot.springbootproj1.dto.User;

public interface UsersRepo extends JpaRepository<User,Integer> {

	public User findByName(String name);
}
