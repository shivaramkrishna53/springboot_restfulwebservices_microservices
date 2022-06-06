package com.socialmedia.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialmedia.app.dtos.PostComments;


public interface Social_Media_Post_Comments_Repo extends JpaRepository<PostComments,Integer> {

	@Query(value = "select pc from PostComments pc where pc.post.user.uemailid=?1 and pc.postcmnt like %?2%")
	public PostComments findByEmailandUserCondition(String emailid,String cmnt);

	public List<PostComments> findBypost_postid(int postid);
}
