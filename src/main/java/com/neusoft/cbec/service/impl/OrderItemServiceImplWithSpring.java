package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IOrderItemDao;
import com.neusoft.cbec.model.OrderItemModel;
import com.nuesoft.cbec.service.IOrderItemService;
@Service
@Transactional
public class OrderItemServiceImplWithSpring implements IOrderItemService {
    IOrderItemDao orderitemdao=null;
    
    @Autowired
	public void setOrderitemdao(IOrderItemDao orderitemdao) {
		this.orderitemdao = orderitemdao;
	}

	@Override
	public void add(OrderItemModel em) throws Exception {

		orderitemdao.create(em);

	}

	@Override
	public void delete(OrderItemModel em) throws Exception {
		
		orderitemdao.delete(em);

	}

	@Override
	public void modify(OrderItemModel em) throws Exception {
		
		orderitemdao.update(em);

	}

	@Override
	public List<OrderItemModel> getListByAll() throws Exception {

		return orderitemdao.selectListByAll();
	}

	@Override
	public OrderItemModel getOrderItemById(int order_id) throws Exception {
		
		return orderitemdao.selectByID(order_id);
	}

}
