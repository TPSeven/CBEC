package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.Pro_PhotosModel;



public interface IPro_photosDao {
	public void create(Pro_PhotosModel photomodel)throws Exception;
	  
	public void update(Pro_PhotosModel photomodel)throws Exception;
   
    public void delete(Pro_PhotosModel photomodel)throws Exception;
    //取得所有图片分页，关联产品表
    public List<Pro_PhotosModel>  selectListWithProductByAll() throws Exception;
    
    public int selectCountByAll() throws Exception;
	

}
