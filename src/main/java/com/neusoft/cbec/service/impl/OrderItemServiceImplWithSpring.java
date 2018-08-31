package com.neusoft.cbec.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	@Override
	public List<OrderItemModel> getListWithManByAll() throws Exception {
		
		return orderitemdao.selectListWithManByAll();
	}

	@Override
	public List<OrderItemModel> getListByCondition(int order_id, int man_id,Date startDate, Date endDate,String man_name,String state) throws Exception {
	
		return orderitemdao.selectListByCondition(order_id, man_id, startDate, endDate,man_name,state);
	}

	@Override
	public List<OrderItemModel> getListByConditionWithPage(int order_id, int man_id, Date startDate, Date endDate,String man_name, String state,int rows,
			int page)
			throws Exception {
	
		return orderitemdao.selectListByConditionWithPage(order_id, man_id,startDate, endDate,man_name,state,rows*(page-1)+1,rows*page);
	}

	@Override
	public int getCountByCondition(int order_id, int man_id, Date startDate, Date endDate, String man_name,String state)
			throws Exception {
	  return orderitemdao.selectCountByCondition(order_id, man_id, startDate, endDate,man_name, state);
	}

	@Override
	public int getPageByConditionWithPage(int order_id, int man_id, Date startDate, Date endDate, String man_name,String state,
			int rows) throws Exception {
		int pageCount =0;
		int count =this.getCountByCondition(order_id, man_id, startDate, endDate, man_name,state);
		if(count%rows==0) {
		  pageCount=count/rows;
		}else {
			  pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public boolean validate(int order_id, int man_id) throws Exception {
		 System.out.println("ok1");
        boolean result = false;
        if(orderitemdao.selectCountByloginId(order_id, man_id)>0) {
   		 System.out.println("ok3");
        	result=true;
        }
		return result;
	}

	@Override
	public List<OrderItemModel> getOrderitemByMan(int order_id,Date startDate,Date endDate,String state) throws Exception {
		
		return orderitemdao.selectListByManufacturer(order_id,startDate,endDate,state);
	}

	@Override
	public int getPageByManWithPage(int order_id,Date startDate,Date endDate,String state, int rows) throws Exception {
		int pageCount =0;
		int count =this.getCountByMan(order_id,startDate,endDate,state);
		if(count%rows==0) {
		  pageCount=count/rows;
		}else {
			  pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public int getCountByMan(int order_id,Date startDate,Date endDate,String state) throws Exception {
		  return orderitemdao.selectCountByMan(order_id,startDate,endDate,state);
	}

	@Override
	public List<OrderItemModel> getOrderitemByManWithPage(int order_id, Date startDate, Date endDate,String state, int start, int end) throws Exception {
		return orderitemdao.selectListByManufacturerWithPage(order_id,startDate,endDate,state, start, end);
	}

}
