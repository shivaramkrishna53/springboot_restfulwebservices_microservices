package com.socialmedia.app.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PostComments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postcmntid;
	private String postcmnt;
	private boolean ispostactive;
	private Date posteddate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="postid")
	private Posts post;

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

	public boolean isIspostactive() {
		return ispostactive;
	}

	public void setIspostactive(boolean ispostactive) {
		this.ispostactive = ispostactive;
	}

	public Date getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}

	@JsonBackReference
	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "PostComments [postcmntid=" + postcmntid + ", postcmnt=" + postcmnt + ", ispostactive=" + ispostactive
				+ ", posteddate=" + posteddate + ", post=" + post + "]";
	}
	
	

}
