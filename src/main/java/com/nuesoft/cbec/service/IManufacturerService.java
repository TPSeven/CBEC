package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.ManufacturerModel;

public interface IManufacturerService {
	public void add(ManufacturerModel manufacturer) throws Exception;
	public void delete(ManufacturerModel manufacturer) throws Exception;
	public void modify(ManufacturerModel manufacturer) throws Exception;
	
	public List<ManufacturerModel> getListByAll() throws Exception;
	
	public ManufacturerModel getManufacturerById(int id) throws Exception;
	public ManufacturerModel getManufacturerWithOrderItemById(int id) throws Exception;
	public  List<ManufacturerModel> getListWithOrderitemsByAll() throws Exception;
	
	public  List<ManufacturerModel> getListWithBrandsByAll() throws Exception;
	
	public   ManufacturerModel getManufacturerWithBrandsById(int id) throws Exception;
	  //检查制定的订单是否可以被删除
	    public boolean checkCanDelete(int  man_id) throws Exception;
}
