package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.ManufacturerModel;
import com.neusoft.cbec.model.OrderItemModel;

public interface IOrderItemService {


		public void add(OrderItemModel em) throws Exception;
		public void delete(OrderItemModel em) throws Exception;
		public void modify(OrderItemModel em) throws Exception;
		
		public List<OrderItemModel> getListByAll() throws Exception;
		public OrderItemModel getOrderItemById(int order_id) throws Exception;
}
