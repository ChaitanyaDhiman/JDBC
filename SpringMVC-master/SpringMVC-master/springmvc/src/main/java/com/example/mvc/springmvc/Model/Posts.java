package com.example.mvc.springmvc.Model;

public class Posts {

	int id;
	String title;
	String auth;
	String desc;
	public Posts(int id, String title, String auth, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.auth = auth;
		this.desc = desc;
	}
	public Posts() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", auth=" + auth + ", desc=" + desc + "]";
	}
	
	
}
