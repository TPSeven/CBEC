package com.neusoft.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

//商品分类表
@Alias("Kinds")
public class KindsModel {
	private int pro_kinds_id = 0;
	private String pro_kinds_name = null;
	
	//关联的商品表
	private List<ProductModel> product=null;
	
	public int getPro_kinds_id() {
		return pro_kinds_id;
	}
	public void setPro_kinds_id(int pro_kinds_id) {
		this.pro_kinds_id = pro_kinds_id;
	}
	public String getPro_kinds_name() {
		return pro_kinds_name;
	}
	public void setPro_kinds_name(String pro_kinds_name) {
		this.pro_kinds_name = pro_kinds_name;
	}
	public List<ProductModel> getProduct() {
		return product;
	}
	public void setProduct(List<ProductModel> product) {
		this.product = product;
	}
	
	
	
	
	
	

}
