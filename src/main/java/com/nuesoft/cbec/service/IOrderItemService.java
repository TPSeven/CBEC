package com.nuesoft.cbec.service;

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
}
