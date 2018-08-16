package com.neusoft.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl
 * Manufacturer Bean -制造商
 */
@Alias("Manufacturer")
public class ManufacturerModel {
	private int id = 0;
	private int no = 0;
	private String name = null;
	private byte[] log = null;
	private String phone = null;
	private String address = null;
	private String mdesc = null;

	//关联的订单列表
	private List<OrderItemModel>  orderitems=null;
	
	public List<OrderItemModel> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<OrderItemModel> orderitems) {
		this.orderitems = orderitems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getLog() {
		return log;
	}
	public void setLog(byte[] log) {
		this.log = log;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	
	
}
