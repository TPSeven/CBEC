package com.neusoft.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
		manufacturerDao.delete(manufacturer);
	}

	@Override
	public void modify(ManufacturerModel manufacturer) throws Exception {
		manufacturerDao.update(manufacturer);
	}

	@Override
	public List<ManufacturerModel> getListByAll() throws Exception {
		return manufacturerDao.selectListByAll();
	}

	@Override
	public ManufacturerModel getManufacturerById(int id) throws Exception {
		if(manufacturerDao.selectManufacturerById(id)==null) {
			System.out.println("id="+id);
			System.out.println("空的");
		}
		return manufacturerDao.selectManufacturerById(id);
	}

	@Override
	public List<ManufacturerModel> getListWithOrderitemsByAll() throws Exception {

		return manufacturerDao.selectListWithOrderitemsByAll();
	}

	@Override

	public List<ManufacturerModel> getListWithBrandsByAll() throws Exception {
		
		return manufacturerDao.selectListWithBrandsByAll();
	}

	@Override
	public ManufacturerModel getManufacturerWithBrandsById(int id) throws Exception {
		
		return manufacturerDao.selectManufacturerWithBrandsById(id);
	}

	public ManufacturerModel getManufacturerWithOrderItemById(int id) throws Exception {
	
		return manufacturerDao.selectManufacturerWithOrderItemById(id);

	}
}

/*
String resource = "wwl-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
SqlSession session =sqlSessionFactory.openSession();
IManufacturerDao manufacturerDao = session.getMapper(IManufacturerDao.class);
manufacturerDao.create(manufacturer);
session.commit();
session.close();
*/
