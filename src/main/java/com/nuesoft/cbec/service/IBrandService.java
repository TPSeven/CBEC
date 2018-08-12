package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.BrandModel;



public interface IBrandService {
	public void add(BrandModel brandmodel) throws Exception;
	
	public List<BrandModel> getListByAll() throws Exception;

}
