package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.BrandModel;
import com.neusoft.cbec.model.Pro_PhotosModel;

public interface IPro_PhotosService {
	
   
	public void add(Pro_PhotosModel photoModel) throws Exception;
	
    public void modify(Pro_PhotosModel photoModel)throws Exception;
	
	public void delete(Pro_PhotosModel photoModel)throws Exception;
	
	public List<Pro_PhotosModel> getListWithPhotosByAll() throws Exception;
	

}
