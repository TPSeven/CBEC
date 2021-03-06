package com.neusoft.cbec.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**/
@Alias("OrderItem")
public class OrderItemModel {
	
			 private int order_id =0;
			 private int pro_id=0;
			 private int pro_id_count=0;
			 private int seller_id=0;
			 private String state=null;
	//	 private int man_id=0;
			 
				@DateTimeFormat(pattern="yyyy-MM-dd")
				@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
			private Date  order_date=null;
         	
			private ManufacturerModel manufacture=null;
				
			 
			 
			/*public int getMan_id() {
				return man_id;
			}
			public void setMan_id(int man_id) {
				this.man_id = man_id;
			}*/
			public Date getOrder_date() {
				return order_date;
			}
			public void setOrder_date(Date order_date) {
				this.order_date = order_date;
			}
		
	
			public ManufacturerModel getManufacture() {
				return manufacture;
			}
			public void setManufacture(ManufacturerModel manufacture) {
				this.manufacture = manufacture;
			}
			public int getOrder_id() {
				return order_id;
			}
			public void setOrder_id(int order_id) {
				this.order_id = order_id;
			}
			public int getPro_id() {
				return pro_id;
			}
			public void setPro_id(int pro_id) {
				this.pro_id = pro_id;
			}
			public int getPro_id_count() {
				return pro_id_count;
			}
			public void setPro_id_count(int pro_id_count) {
				this.pro_id_count = pro_id_count;
			}	
			public int getSeller_id() {
				return seller_id;
			}
			public void setSeller_id(int seller_id) {
				this.seller_id = seller_id;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			

}
