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

import com.neusoft.cbec.dao.IBrandDao;

import com.neusoft.cbec.model.BrandModel;
import com.nuesoft.cbec.service.IBrandService;

@Service
@Transactional
public class BrandServiceImpl implements IBrandService {
    //MyBatis����Spring���Service����
	private IBrandDao brandDao = null;
	
	@Autowired
	public void setBrandDao(IBrandDao brandDao) {
		this.brandDao = brandDao;
	}
	
	@Override
	public void add(BrandModel brandmodel) throws Exception {
		brandDao.create(brandmodel);
		/*String resource = "mjh-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session =sqlSessionFactory.openSession();
		IBrandDao brand = session.getMapper(IBrandDao.class);
		brand.create(brandmodel);
		session.commit();
		session.close();*/

	}

	@Override
	public List<BrandModel> getListByAll() throws Exception {
		return brandDao.selectListByAll();
		
	}

	@Override
	public void  modify(BrandModel brandmodel) throws Exception {
		brandDao.update(brandmodel);
		
	}

	@Override
	public BrandModel getById(int Id) throws Exception {
		 return brandDao.selectById(Id);
		}

	@Override
	public void delete(BrandModel brandmodel) throws Exception {
		brandDao.delete(brandmodel);
		
	}

	@Override
	public List<BrandModel> getListWithManuByAll() throws Exception {
		return brandDao.selectListWithManuByAll();
	}
	

}
