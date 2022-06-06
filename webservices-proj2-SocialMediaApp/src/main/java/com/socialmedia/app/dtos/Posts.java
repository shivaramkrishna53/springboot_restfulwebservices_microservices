package com.socialmedia.app.dtos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postid;
	private String postdesc;
	private int postlikescnt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="uid")
	private Users user;
	
	@OneToMany(mappedBy = "post",fetch = FetchType.EAGER)
	private List<PostComments> postcmnts;

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public String getPostdesc() {
		return postdesc;
	}

	public void setPostdesc(String postdesc) {
		this.postdesc = postdesc;
	}

	public int getPostlikescnt() {
		return postlikescnt;
	}

	public void setPostlikescnt(int postlikescnt) {
		this.postlikescnt = postlikescnt;
	}

	


	
	
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}

    @JsonBackReference
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Posts [postid=" + postid + ", postdesc=" + postdesc + ", postlikescnt=" + postlikescnt + ", user="
				+ user  +"]";
	}

	@JsonManagedReference
	public List<PostComments> getPostcmnts() {
		return postcmnts;
	}

	public void setPostcmnts(List<PostComments> postcmnts) {
		this.postcmnts = postcmnts;
	}

	
	
	
	
	
	
	
	

}
