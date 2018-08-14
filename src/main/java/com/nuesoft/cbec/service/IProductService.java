package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.ProductModel;

public interface IProductService {
	//增加
	public void add(ProductModel product) throws Exception;
	//修改
	public void modify(ProductModel product) throws Exception;
	//删除
	public void delete(ProductModel product) throws Exception;
	//查询
	public List<ProductModel> getListByAll() throws Exception;
	//按编号查询
	public ProductModel getById(int productId) throws Exception;
	

}
