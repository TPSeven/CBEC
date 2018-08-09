package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.ManufacturerModel;

/**
 * @author Wwl
 * 制造商接口
 */
public interface IManufacturerDao {
	public void create(ManufacturerModel manufacturer) throws Exception;
	public void delete(ManufacturerModel manufacturer) throws Exception;
	public void update(ManufacturerModel manufacturer) throws Exception;
	
	public List<ManufacturerModel> selectListByAll() throws Exception;
	
	public ManufacturerModel selectManufacturerById(int no) throws Exception;
}
