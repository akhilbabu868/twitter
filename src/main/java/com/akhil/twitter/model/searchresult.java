package com.akhil.twitter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class searchresult {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String latesttweet;
	private String profileurl;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLatesttweet() {
		return latesttweet;
	}
	public void setLatesttweet(String latesttweet) {
		this.latesttweet = latesttweet;
	}
	public String getProfileurl() {
		return profileurl;
	}
	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public searchresult(int id, String latesttweet, String profileurl,String name ) {
		super();
		this.id = id;
		this.latesttweet = latesttweet;
		this.profileurl = profileurl;
		this.name = name;
	}

	public searchresult() {
		
		
	}
	
	
}
