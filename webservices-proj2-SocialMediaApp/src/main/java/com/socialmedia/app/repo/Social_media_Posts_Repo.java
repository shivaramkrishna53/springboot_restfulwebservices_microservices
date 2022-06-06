package com.socialmedia.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.dtos.Posts;


public interface Social_media_Posts_Repo extends JpaRepository<Posts,Integer> {

	@Query(value = "select p from Posts p where p.user.uname=?1 and p.postdesc=?2")
	public Posts findByConditon(String uname,String postdesc);

	public Posts findByUser_uid(int uid);
}
