package com.neusoft.cbec.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("Product")
public class ProductModel {
	
	private int pro_id = 0;
	private String pro_name=null;
	private double pro_price=0;
	private double pro_weight=0;
	private int pro_count = 0;
	private int pro_kinds_id = 0;
	private int pro_state_id = 0;
	private int brand_id = 0;
	private int pro_photos_id = 0;
	private String pro_desc = null;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date up_date=null; //更新日期
	
	//关联-商品类型
	private KindsModel kinds = null;
	
	
	public KindsModel getKinds() {
		return kinds;
	}
	public void setKinds(KindsModel kinds) {
		this.kinds = kinds;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public double getPro_price() {
		return pro_price;
	}
	public void setPro_price(double pro_price) {
		this.pro_price = pro_price;
	}
	public double getPro_weight() {
		return pro_weight;
	}
	public void setPro_weight(double pro_weight) {
		this.pro_weight = pro_weight;
	}
	public int getPro_count() {
		return pro_count;
	}
	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}
//	public int getPro_kinds_id() {
//		return pro_kinds_id;
//	}
//	public void setPro_kinds_id(int pro_kinds_id) {
//		this.pro_kinds_id = pro_kinds_id;
//	}
	public int getPro_state_id() {
		return pro_state_id;
	}
	public void setPro_state_id(int pro_state_id) {
		this.pro_state_id = pro_state_id;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public int getPro_photos_id() {
		return pro_photos_id;
	}
	public void setPro_photos_id(int pro_photos_id) {
		this.pro_photos_id = pro_photos_id;
	}
	public String getPro_desc() {
		return pro_desc;
	}
	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}
	public int getPro_kinds_id() {
		return pro_kinds_id;
	}
	public void setPro_kinds_id(int pro_kinds_id) {
		this.pro_kinds_id = pro_kinds_id;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	
	
	
}
