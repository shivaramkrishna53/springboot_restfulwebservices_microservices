package com.in28mins.webservices.webservicesproj1.dto;

public class Users {
	
	private int uid;
	private String uname;
	private float usal;
	private String uaddrs;
	public Users(int userid) {
		uid=userid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public float getUsal() {
		return usal;
	}
	public void setUsal(float usal) {
		this.usal = usal;
	}
	public String getUaddrs() {
		return uaddrs;
	}
	public void setUaddrs(String uaddrs) {
		this.uaddrs = uaddrs;
	}
	

}
