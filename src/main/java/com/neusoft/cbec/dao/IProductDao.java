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
	//查询所有
	public List<ProductModel> selectListByAll() throws Exception;
	//查询所有-分页
	public List<ProductModel> selectListByAllWithPage(int rows,int page) throws Exception;
	
	//查询所有-无关联种类-无分页
	public List<ProductModel> selectListWithoutKindsByAll() throws Exception;
	//查询所有-有关联种类-无分页
	public List<ProductModel> selectListWithKindsByAll() throws Exception;
	
	//取得指定种类的商品-无分页
	public List<ProductModel> selectListByKinds() throws Exception;
	//取得指定种类的商品-有分页
	public List<ProductModel> selectListByKindsWithPage() throws Exception;
	
	//取得指定编号商品信息（单个对象）
	public ProductModel selectById(int productId) throws Exception;
	//取得所有商品个数
	public int selectCountByAll() throws Exception;
	
}
