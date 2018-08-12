package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.ManufacturerModel;

public interface IManufacturerService {
	public void add(ManufacturerModel manufacturer) throws Exception;
	public void delete(ManufacturerModel manufacturer) throws Exception;
	public void modify(ManufacturerModel manufacturer) throws Exception;
	
	public List<ManufacturerModel> getListByAll() throws Exception;
	
	public ManufacturerModel getManufacturerById(int id) throws Exception;
}
