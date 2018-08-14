package com.neusoft.cbec.model;

public class UserModel {
	private int id = 0;
	private String name = null;
	private String password = null;
	private String email = null;
	private String phone = null;
	private String droits = null;//权限
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDroits() {
		return droits;
	}
	public void setDroits(String droits) {
		this.droits = droits;
	}
	
}

