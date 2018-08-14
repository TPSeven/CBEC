package com.neusoft.cbec.model;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl
 * 用户角色
 */
@Alias("Role")
public class RoleModel {
	private int id;
	private String name;
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
	
}
