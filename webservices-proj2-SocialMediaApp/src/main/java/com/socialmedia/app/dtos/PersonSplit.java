package com.socialmedia.app.dtos;

public class PersonSplit {
	
	private FullName fullname;

	public PersonSplit(FullName fullname) {
		super();
		this.fullname = fullname;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "PersonSplit [fullname=" + fullname + "]";
	}

}
