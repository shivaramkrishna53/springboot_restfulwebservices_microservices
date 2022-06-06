package com.socialmedia.app.dtos;

import java.util.Date;

public class ResultDtoQuerySample {

	private Integer uid;
	private String uname;
	private String uemailid;
	private String ustatus;
	private Integer postid;
	private String postdesc;
	private int postlikescnt;
	private int postcmntid;
	private String postcmnt;
	private Date posteddate;
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
	public String getUstatus() {
		return ustatus;
	}
	public void setUstatus(String ustatus) {
		this.ustatus = ustatus;
	}
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
	public int getPostcmntid() {
		return postcmntid;
	}
	public void setPostcmntid(int postcmntid) {
		this.postcmntid = postcmntid;
	}
	public String getPostcmnt() {
		return postcmnt;
	}
	public void setPostcmnt(String postcmnt) {
		this.postcmnt = postcmnt;
	}
	public Date getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}
	@Override
	public String toString() {
		return "ResultDtoQuerySample [uid=" + uid + ", uname=" + uname + ", uemailid=" + uemailid + ", ustatus="
				+ ustatus + ", postid=" + postid + ", postdesc=" + postdesc + ", postlikescnt=" + postlikescnt
				+ ", postcmntid=" + postcmntid + ", postcmnt=" + postcmnt + ", posteddate=" + posteddate + "]";
	}
	
	
}
