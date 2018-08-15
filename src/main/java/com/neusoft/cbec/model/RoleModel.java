package com.neusoft.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl
 * 用户角色
 */
@Alias("Role")
public class RoleModel {
	private int id = 0;
	private String name = null ;
	
	//关联用户
	private List<UserModel> users = null;
	
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
	public List<UserModel> getUsers() {
		return users;
	}
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	
}
