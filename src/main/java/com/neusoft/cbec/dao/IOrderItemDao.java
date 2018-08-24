package com.neusoft.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
   //根据检索条件取得订单的列表 ,无分页
    public List<OrderItemModel> selectListByCondition(@Param("order_id")int order_id,@Param("man_id")int man_id,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("man_name")String man_name,@Param("state")String state) throws Exception;
    
    //根据检索条件取得订单的列表 ,有分页
    public List<OrderItemModel> selectListByConditionWithPage(@Param("order_id")int order_id,@Param("man_id")int man_id,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("man_name")String man_name,@Param("state")String state,@Param("start")int start,@Param("end")int end) throws Exception;
    //根据检索条件取得订单的个数
    public int selectCountByCondition(@Param("order_id")int order_id,@Param("man_id")int man_id,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("man_name")String man_name,@Param("state")String state) throws Exception;
    
    //取得订单编号
   public OrderItemModel selectByID(int order_id) throws Exception;
   //订单个数
    public int selectCountByAll() throws Exception;
    
    //取得指定制造商的订单列表 
    public List<OrderItemModel>  selectListByManufacturer(int man_id)throws Exception;
    //验证登陆
    public int selectCountByloginID (int order_id ,int man_id )throws Exception;
    
}
