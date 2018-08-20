package com.neusoft.cbec.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	public List<ProductModel> selectListByKinds(int kindsId) throws Exception;
	
	//取得指定种类的商品-有分页
	public List<ProductModel> selectListByKindsWithPage(int rows,int page,int kindsId) throws Exception;
	
	//取得指定编号商品信息（单个对象）
	public ProductModel selectById(int productId) throws Exception;
	//取得所有商品个数
	public int selectCountByAll() throws Exception;
	
	//根据检索条件取得员工列表-无分页
	public List<ProductModel> selectListByCondition(@Param("kindsId") int kindsId,@Param("pro_price") int price,@Param("brand") int brand,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("name") String name)throws Exception;
	//根据检索条件取得员工列表-有分页
	public List<ProductModel> selectListByConditionWithPage(@Param("kindsId") int kindsId,@Param("pro_price") int price,@Param("brand") int brand,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("name") String name,@Param("rows") int rows,@Param("page") int page)throws Exception;
	
	//根据检索条件取得员工个数
	public int selectCountByCondition(@Param("kindsId") int kindsId,@Param("pro_price") int price,@Param("brand") int brand,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("name") String name) throws Exception;
}
