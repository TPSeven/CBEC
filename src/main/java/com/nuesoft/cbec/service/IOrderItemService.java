package com.nuesoft.cbec.service;

import java.util.Date;
import java.util.List;

import com.neusoft.cbec.model.ManufacturerModel;
import com.neusoft.cbec.model.OrderItemModel;

public interface IOrderItemService {


		public void add(OrderItemModel em) throws Exception;
		public void delete(OrderItemModel em) throws Exception;
		public void modify(OrderItemModel em) throws Exception;
		//取得订单列表,无关制造商
		public List<OrderItemModel> getListByAll() throws Exception;
		//取得订单列表，取得制造商
		public List<OrderItemModel> getListWithManByAll() throws Exception;
		public OrderItemModel getOrderItemById(int order_id) throws Exception;
		//根据检索条件取得订单的列表 ,无分页
	    public List<OrderItemModel> getListByCondition(int order_id,int man_id,Date startDate,Date endDate,String man_name) throws Exception;
	    
	    //根据检索条件取得订单的列表 ,有分页
	    public List<OrderItemModel> getListByConditionWithPage(int order_id,int man_id,Date startDate,Date endDate,String man_name,int start,int end) throws Exception;
		//根据检索条件取得订单个数
	    public int  getCountByCondition(int order_id,int man_id,Date startDate,Date endDate,String man_name) throws Exception;
        //根据检索条件取得订单的页数
	    public int getPageByConditionWithPage(int order_id,int man_id,Date startDate,Date endDate,String man_name,int rows) throws Exception;
 }
