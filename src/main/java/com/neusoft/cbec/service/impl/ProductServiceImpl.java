package com.neusoft.cbec.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.neusoft.cbec.dao.IProductDao;
import com.neusoft.cbec.model.ProductModel;
import com.nuesoft.cbec.service.IProductService;

public class ProductServiceImpl implements IProductService {

	@Override
	public void add(ProductModel product) throws Exception {
		
		String resource = "link-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		IProductDao productDao=session.getMapper(IProductDao.class);
		productDao.create(product);
		session.commit();
		session.close();

	}

	@Override
	public void modify(ProductModel product) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ProductModel product) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductModel> getListByAll() throws Exception {
		String resource = "link-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		IProductDao productDao=session.getMapper(IProductDao.class);
		List<ProductModel> list = productDao.selectListByAll();
		session.commit();
		session.close();
		return list;
	}

	@Override
	public ProductModel getById(String productId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getListWithoutKindsByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getListWithKindsByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<ProductModel> getListByCondition(int kindsId, int sprice, int eprice, int brand, Date startDate,
			Date endDate, String name, String state) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int getPageCountByCondition(int brandId,int kindsId, int sprice, int eprice, int brand, Date startDate, Date endDate,
			String name, String state, int rows) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductModel getByIdWithKinds(String productId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getListByConditionWithPage(int brandId, int kindsId, int sprice, int eprice, int brand,
			Date startDate, Date endDate, String name, String state, int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByCondition(int brandId, int kindsId, int sprice, int eprice, int brand, Date startDate,
			Date endDate, String name, String state) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}





}
