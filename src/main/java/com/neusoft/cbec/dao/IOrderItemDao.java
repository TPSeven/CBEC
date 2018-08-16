package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.OrderItemModel;


public interface IOrderItemDao {
  // 增
	//@Insert("insert into  ORDER_ITEM (Order_id,pro_id,pro_id_count,man_id,seller_id,state)")
	public void create(OrderItemModel em)throws Exception;
  //修
	public void update(OrderItemModel em)throws Exception;
   //删
    public void delete(OrderItemModel em)throws Exception;
   //取得所有订单,无关联制造商
    public List<OrderItemModel> selectListByAll() throws Exception;
    //取得所有订单,取得联制造商
    public List<OrderItemModel> selectListWithManByAll() throws Exception;
   //分页
    public List<OrderItemModel>  selectListByAllWithPage(int rows,int page) throws Exception;
   //取得订单编号
   public OrderItemModel selectByID(int order_id) throws Exception;
   //订单个数
    public int selectCountByAll() throws Exception;
    
    //取得指定制造商的订单列表 
    public List<OrderItemModel>  selectListByManufacturer(int man_id)throws Exception;
    
}
