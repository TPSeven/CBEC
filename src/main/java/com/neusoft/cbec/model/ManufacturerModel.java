package com.neusoft.cbec.model;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl
 * Manufacturer Bean -制造商
 */
@Alias("Manufacturer")
public class ManufacturerModel {
	private int id = 0;
	private String name = null;
	private String address = null;
	private String scope = null;
	private String desc = null;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
