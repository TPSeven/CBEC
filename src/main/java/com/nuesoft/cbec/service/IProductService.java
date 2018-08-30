package com.nuesoft.cbec.service;

import java.util.Date;
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
	public ProductModel getById(String productId) throws Exception;
	//按编号查询-关联种类
	public ProductModel getByIdWithKinds(String productId) throws Exception;
	
	
	//取得所有商品列表-无关联种类-无分页
	public List<ProductModel> getListWithoutKindsByAll() throws Exception;
	//取得所有商品列表-有关联种类-无分页
	public List<ProductModel> getListWithKindsByAll() throws Exception;
	
	
	public List<ProductModel> getListByCondition(int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state)throws Exception;
	public List<ProductModel> getListByConditionWithPage(int brandId,int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state,int rows,int page)throws Exception;

	//根据检索条件取得商品个数
	public int getCountByCondition(int brandId,int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state) throws Exception;
	//根据检索条件取得商品总页数
	public int getPageCountByCondition(int brandId,int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state,int rows) throws Exception;
}
