package com.neusoft.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("seller")
public class SellerModel {
    private int seller_id=0;
    private  int seller_no=0;
    private String seller_name=null;
    private int seller_phone=0;
    private String  seller_address=null;
    private  String seller_desc=null;
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getSeller_no() {
		return seller_no;
	}
	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public int getSeller_phone() {
		return seller_phone;
	}
	public void setSeller_phone(int seller_phone) {
		this.seller_phone = seller_phone;
	}
	public String getSeller_address() {
		return seller_address;
	}
	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}
	public String getSeller_desc() {
		return seller_desc;
	}
	public void setSeller_desc(String seller_desc) {
		this.seller_desc = seller_desc;
	}
    
}
