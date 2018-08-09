package com.neusoft.cbec.dao;

import com.neusoft.cbec.model.ProductModel;

/**
 * @author link
 * 商品接口
 */
public interface IProductDao {
	//新建商品
	public void  create (ProductModel pd) throws Exception;
}
