package com.neusoft.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	public List<ProductModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
