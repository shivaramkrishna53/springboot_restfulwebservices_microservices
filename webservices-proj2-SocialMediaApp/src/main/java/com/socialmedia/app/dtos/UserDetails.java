package com.socialmedia.app.dtos;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class UserDetails implements Serializable {
	
	 private String uname;
	 private String uemailid;
	
	
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
		return "UserDetails [ uname=" + uname + ", uemailid=" + uemailid + "]";
	}
	
	public UserDetails() {
		super();
	}
	
	 
	
}
