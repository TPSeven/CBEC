package com.nuesoft.cbec.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.cbec.model.BrandModel;




public interface IBrandService {
	public void add(BrandModel brandmodel) throws Exception;
	
	public void modify(BrandModel brandmodel)throws Exception;
	
	public void delete(BrandModel brandmodel)throws Exception;
	
	public List<BrandModel> getListByAll() throws Exception;
	
	public List<BrandModel> getListWithManuByAll() throws Exception;
	
	public  BrandModel getById(int Id) throws Exception;
	//根据检索条件取得品牌商列表，有分页
	public List<BrandModel> getListByConditionWithPage(int manuid,String name,Date startDate,Date endDate,int start,int end) throws Exception;
	
	//根据检索条件取得品牌商列表，无分页
	public List<BrandModel> getListByCondition(int manuid,String name,Date startDate,Date endDate) throws Exception;
	//根据检索条件取得品牌商个数
	public int getCountByCondition(int manuid,String name,Date startDate,Date endDate) throws Exception;
	//根据检索条件取得品牌商显示页数
	public int getPageCountByCondition(int manuid,String name,Date startDate,Date endDate,int rows) throws Exception;

}
