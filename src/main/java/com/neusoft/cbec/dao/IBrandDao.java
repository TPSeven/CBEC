package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.BrandModel;


public interface IBrandDao {
	public void create(BrandModel brandmodel)throws Exception;
	  
	public void update(BrandModel brandmodel)throws Exception;
   
    public void delete(BrandModel brandmodel)throws Exception;
   
    public List<BrandModel> selectListByAll() throws Exception;
   
    public List<BrandModel>  selectListByAllWithPage(int rows,int page) throws Exception;
   
   public BrandModel selectByID(int brand_id) throws Exception;
   
    public int selectCountByAll() throws Exception;
    

}
