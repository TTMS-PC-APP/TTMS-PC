package com.ttms.model;

public class User {
	Integer id;
	String username;
	String password;
	String type;
	String u_photo;
	String img_string;
	public String getImg_string() {
		return img_string;
	}
	public void setImg_string(String img_string) {
		this.img_string = img_string;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getU_photo() {
		return u_photo;
	}
	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}
	
	
	
}
