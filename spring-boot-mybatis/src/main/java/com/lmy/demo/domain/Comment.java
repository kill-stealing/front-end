package com.lmy.demo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {
	private int id;
	private int productId;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp;
	private String user;
	private float rating;
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Comment(int id, int productId, Date timestamp, String user,
			float rating, String content) {
		super();
		this.id = id;
		this.productId = productId;
		this.timestamp = timestamp;
		this.user = user;
		this.rating = rating;
		this.content = content;
	}
	public Comment(){
		
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", productId=" + productId
				+ ", timestamp=" + timestamp + ", user=" + user + ", rating="
				+ rating + ", content=" + content + "]";
	}
}
