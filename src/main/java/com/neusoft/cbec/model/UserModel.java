package com.neusoft.cbec.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Wwl
 * 用户表
 */
@Alias("User")
public class UserModel {
	//主键
	private int id = 0;
	
	private String name = null;
	private String password = null;
	private String sex = null;
	private int age = 0;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date birthday = null;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date joinDate = null;
	private byte[] portrait = null; //头像
	private String portraitFileName = null;
	private String portraitContentType = null;
	private String email = null;
	private String phone = null;
	private String desc = null;
	
	//关联的属性,外键
	private List<RoleModel> roles = null;//权限
	
	private int man_id = 0;
	private int wallet_id = 0;
	private int seller_id = 0;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public byte[] getPortrait() {
		return portrait;
	}
	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
	}
	public String getPortraitFileName() {
		return portraitFileName;
	}
	public void setPortraitFileName(String portraitFileName) {
		this.portraitFileName = portraitFileName;
	}
	public String getPortraitContentType() {
		return portraitContentType;
	}
	public void setPortraitContentType(String portraitContentType) {
		this.portraitContentType = portraitContentType;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<RoleModel> getRoles() {
		return roles;
	}
	public void setRole(List<RoleModel> roles) {
		this.roles = roles;
	}
	public int getMan_id() {
		return man_id;
	}
	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}
	public int getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

}

