package com.neusoft.cbec.model;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl
 * 用户表
 */
@Alias("User")
public class UserModel {
	private int id = 0;
	private String name = null;
	private String password = null;
	private String sex = null;
	private byte[] portrait = null; //头像
	private String email = null;
	private String phone = null;
	
	//关联的属性
	private RoleModel role = null;//权限
	
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public byte[] getPortrait() {
		return portrait;
	}
	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
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
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}

	
}

