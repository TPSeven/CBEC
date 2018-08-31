package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.OrderItemModel;
import com.neusoft.cbec.model.SellerModel;



public interface ISellerDao {
	// 增
		//@Insert("insert into  ORDER_ITEM (Order_id,pro_id,pro_id_count,man_id,seller_id,state)")
		public void create(SellerModel se)throws Exception;
	  //修
		public void update(SellerModel se)throws Exception;
	   //删
	    public void delete(SellerModel se)throws Exception;
	   //取得所有借卖方,无关联订单
	    public List<SellerModel> selectListByAll() throws Exception;
	    //根据ID取得借卖方
	    public SellerModel selectByID(int seller_id) throws Exception;
        
         
}
