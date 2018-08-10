package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IManufacturerDao;
import com.neusoft.cbec.model.ManufacturerModel;
import com.nuesoft.cbec.service.IManufacturerService;

/**
 * @author Wwl 温万龙
 * spring+mybaits实现制造商服务层接口
 */
@Service
@Transactional
public class ManufacturerServiceImplWithSpring implements IManufacturerService {
	
	public IManufacturerDao manufacturerDao = null;
	
	@Autowired
	public void setManufacturerDao(IManufacturerDao manufacturerDao) {
		this.manufacturerDao = manufacturerDao;
	}

	@Override
	public void add(ManufacturerModel manufacturer) throws Exception {
		manufacturerDao.create(manufacturer);
	}

	@Override
	public void delete(ManufacturerModel manufacturer) throws Exception {
		
	}

	@Override
	public void modify(ManufacturerModel manufacturer) throws Exception {

	}

	@Override
	public List<ManufacturerModel> getListByAll() throws Exception {
		return null;
	}

	@Override
	public ManufacturerModel getManufacturerById(int no) throws Exception {
		return null;
	}
}
