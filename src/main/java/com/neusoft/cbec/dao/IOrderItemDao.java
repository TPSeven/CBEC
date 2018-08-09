package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.OrderItemModel;


public interface IOrderItemDao {

	public void create(OrderItemModel em)throws Exception;
  
	public void update(OrderItemModel em)throws Exception;
   
    public void delete(OrderItemModel em)throws Exception;
   
    public List<OrderItemModel> selectListByAll() throws Exception;
   
    public List<OrderItemModel>  selectListByAllWithPage(int rows,int page) throws Exception;
   
   public OrderItemModel selectByID(int order_id) throws Exception;
   
    public int selectCountByAll() throws Exception;
    
}
