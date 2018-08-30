

/*
 *  @author Jarvis
**   Brand  品牌商
**/
package com.neusoft.cbec.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Brand")
public class BrandModel {
	private int brand_id = 0;

	private String brand_name =null;
	
	private String brand_desc = null;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private Date brand_time = null;      //公司注册时间
	//关联属性
	
	//man_id = manufacturer.id
	private ManufacturerModel manufacturer = null;
	
	public Date getBrand_time() {
		return brand_time;
	}
	public void setBrand_time(Date brand_time) {
		this.brand_time = brand_time;
	}
	public ManufacturerModel getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(ManufacturerModel manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getBrand_desc() {
		return brand_desc;
	}
	public void setBrand_desc(String brand_desc) {
		this.brand_desc = brand_desc;
	}

	

	
	

}
