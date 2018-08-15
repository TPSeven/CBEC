package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.BrandModel;



public interface IBrandService {
	public void add(BrandModel brandmodel) throws Exception;
	
	public void modify(BrandModel brandmodel)throws Exception;
	
	public void delete(BrandModel brandmodel)throws Exception;
	
	public List<BrandModel> getListByAll() throws Exception;
	
	public List<BrandModel> getListWithManuByAll() throws Exception;
	
	public  BrandModel getById(int Id) throws Exception;
    
	
}
