package com.socialmedia.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Service;

import com.socialmedia.app.dtos.PostComments;
import com.socialmedia.app.dtos.Posts;
import com.socialmedia.app.dtos.ResultDtoQuerySample;
import com.socialmedia.app.dtos.ResultDtoSample;
import com.socialmedia.app.dtos.UserDetails;
import com.socialmedia.app.dtos.Users;
import com.socialmedia.app.repo.SocialMediaUsersRepo;
import com.socialmedia.app.repo.Social_Media_Post_Comments_Repo;
import com.socialmedia.app.repo.Social_media_Posts_Repo;

@Service
public class SocialMediaService {
	
	@Autowired
	JdbcTemplate jt;
	
	@Value("${sqlqry}")
	String qry;
	
	@Autowired
	SocialMediaUsersRepo urepo;
	
	@Autowired
	Social_media_Posts_Repo prepo;
	
	@Autowired
	Social_Media_Post_Comments_Repo crepo;
	
	public List<Users> getAllUsers()
	{
		return urepo.findAll();
	}
	
	public Users saveuser(Users u)
	{
		return urepo.save(u);
	}
	
	public List<Users> saveAllInBulk(List<Users> lstusers)
	{
		return urepo.saveAll(lstusers);
	}
	
	public Users findByUserId(Integer id)
	{
		return  urepo.findByuid(id);
	}
	
	public Users deleteResourceById(String id)
	{
		int userid=Integer.parseInt(id);
		Users u=urepo.findByuid(userid);
		if(u!=null)
		{
			
			Posts p=prepo.findByUser_uid(userid);
			List<PostComments> lstpc=crepo.findBypost_postid(p.getPostid());
			for(PostComments pc: lstpc)
				crepo.delete(pc);
			
			
			prepo.delete(p);
			urepo.deleteById(userid);
			return u;
		}
		
		return null;
	}
	
//	public List<Users> findUserByName(String uname)
//	{
//		return urepo.findByudetails_uname(uname);
//	}
	
//	public findbyuidanduname(String username,Integer uid)
//	{
//		urepo.findByudetails_uidand_uname(username,userid);
//	}
	
	
	public List<ResultDtoQuerySample> getalldataquery()
	{
		System.out.println("query is:"+qry);
		return jt.query(qry,new RowMapper<ResultDtoQuerySample>() {

			@Override
			public ResultDtoQuerySample mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ResultDtoQuerySample dto=new ResultDtoQuerySample();
				dto.setUid(rs.getInt("uid"));
				dto.setUname(rs.getString("uname"));
				dto.setUemailid(rs.getString("uemailid"));
				dto.setUstatus(rs.getString("ustatus"));
				dto.setPostid(rs.getInt("postid"));
				dto.setPostdesc(rs.getString("postdesc"));
				dto.setPostlikescnt(rs.getInt("postlikescnt"));
				dto.setPostcmntid(rs.getInt("postcmntid"));
				dto.setPostcmnt(rs.getString("postcmnt"));
				dto.setPosteddate(rs.getTimestamp("posteddate"));
				return dto;
			}});
		
	}
}
