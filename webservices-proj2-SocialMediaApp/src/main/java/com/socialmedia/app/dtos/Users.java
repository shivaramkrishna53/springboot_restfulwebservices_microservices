package com.socialmedia.app.dtos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	@Size(min = 3,message = "Lenght cannot be less than 3")
	private String uname;
	@NotNull(message = "email address is mandatory please enter it")
	private String uemailid;
	@JsonIgnore
	private String upass;
	private String ustatus;
	
	@Null(message = "Put them as Empty since jpa is unable to save all togeather")
	@OneToMany(mappedBy = "user")
	private List<Posts> posts;
	

	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}

	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemailid() {
		return uemailid;
	}
	public void setUemailid(String uemailid) {
		this.uemailid = uemailid;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", uemailid=" + uemailid + ", upass=" + upass + ", ustatus="
				+ ustatus + "]";
	}
	
	//@JsonManagedReference
	public List<Posts> getPosts() {
		return posts;
	}
	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}
	

}
