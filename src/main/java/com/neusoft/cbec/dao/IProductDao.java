package com.neusoft.cbec.dao;


import java.util.List;

import com.neusoft.cbec.model.ProductModel;

/**
 * @author link
 * 商品接口
 */
public interface IProductDao {
	//新建商品
	public void create (ProductModel pd) throws Exception;
	//修改
	public void update (ProductModel pd) throws Exception;
	//删除
	public void delete (ProductModel pd) throws Exception;
	//查询
	public List<ProductModel> selectListByAll() throws Exception;
	
}