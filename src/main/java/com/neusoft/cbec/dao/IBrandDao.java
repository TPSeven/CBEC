package com.neusoft.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.cbec.model.BrandModel;


public interface IBrandDao {
	public void create(BrandModel brandmodel)throws Exception;
	  
	public void update(BrandModel brandmodel)throws Exception;
   
    public void delete(BrandModel brandmodel)throws Exception;
   
    public List<BrandModel> selectListByAll() throws Exception;
    
    public List<BrandModel> selectListWithManuByAll() throws Exception;
   
    public List<BrandModel>  selectListByAllWithPage(int rows,int page) throws Exception;
   //取得指定id的品牌商信息 有关联到制造商
   public BrandModel selectById(int brand_id) throws Exception;
   
    public int selectCountByAll() throws Exception;
    
   //根据检索条件取得员工列表，无分页
    public List<BrandModel> selectListByCondition(@Param("manuid") int manuid, @Param("name")  String name,@Param("startDate") Date startDate, @Param("endDate") Date endDate) throws Exception;

    //根据检索条件取得员工列表，有分页
    public List<BrandModel> selectListByConditionWithPage(@Param("manuid") int manuid, @Param("name")  String name,@Param("startDate") Date startDate, @Param("endDate") Date endDate,@Param("start")  int start,@Param("end")  int end) throws Exception;
    //根据检索条件取得员工个数
    public int selectCountByCondition(@Param("manuid") int manuid, @Param("name")  String name,@Param("startDate") Date startDate, @Param("endDate") Date endDate)throws Exception;
	
    

}
