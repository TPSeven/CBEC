package com.neusoft.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.neusoft.cbec.dao.IManufacturerDao;
import com.neusoft.cbec.model.ManufacturerModel;
import com.nuesoft.cbec.service.IManufacturerService;

/**
 * @author Wwl 温万龙
 *    制造商服务层实现
 */
//@Service
public class ManufacturerServiceImpl implements IManufacturerService {

	@Override
	public void add(ManufacturerModel manufacturer) throws Exception {
		String resource = "wwl-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session =sqlSessionFactory.openSession();
		IManufacturerDao manufacturerDao = session.getMapper(IManufacturerDao.class);
		manufacturerDao.create(manufacturer);
		session.commit();
		session.close();
	}

	@Override
	public void delete(ManufacturerModel manufacturer) throws Exception {
		
	}

	@Override
	public void modify(ManufacturerModel manufacturer) throws Exception {

	}

	@Override
	public List<ManufacturerModel> getListByAll() throws Exception {
		String resource = "wwl-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session =sqlSessionFactory.openSession();
		IManufacturerDao manufacturerDao = session.getMapper(IManufacturerDao.class);
		List<ManufacturerModel> list = manufacturerDao.selectListByAll();
		session.commit();
		session.close();
		return list;
	}

	@Override
	public ManufacturerModel getManufacturerById(int no) throws Exception {
		return null;
	}

	@Override
	public List<ManufacturerModel> getListWithOrderitemsByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManufacturerModel> getListWithBrandsByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManufacturerModel getManufacturerWithBrandsById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
