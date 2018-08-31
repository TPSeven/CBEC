package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.OrderItemModel;
import com.neusoft.cbec.model.SellerModel;

public interface ISellerService {
  
	public void add(SellerModel se) throws Exception;
	public void delete(SellerModel se) throws Exception;
	public void modify(SellerModel se) throws Exception;
	//取得订单列表,无关制造商
	public List<SellerModel> getListByAll() throws Exception;
	
	public SellerModel getSellerById(int seller_id) throws Exception;
}
