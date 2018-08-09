package com.neusoft.cbec.dao;

import com.neusoft.cbec.model.OrderItemModel;

public interface IOrderItemDao {
	public void create(OrderItemModel em)throws Exception;
}
