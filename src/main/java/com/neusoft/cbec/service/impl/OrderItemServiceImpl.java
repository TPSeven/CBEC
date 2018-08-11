package com.neusoft.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.neusoft.cbec.dao.IOrderItemDao;
import com.neusoft.cbec.model.OrderItemModel;
import com.nuesoft.cbec.service.IOrderItemService;
@Service("IOrderItemService")
public class OrderItemServiceImpl implements IOrderItemService {

	@Override
	public void add(OrderItemModel em) throws Exception {
		String resource = "kaoliulian.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderItemDao orderitemDao=session.getMapper(IOrderItemDao.class);
	    orderitemDao.create(em);
	    session.commit();
		session.close();
	}

	@Override
	public void delete(OrderItemModel em) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(OrderItemModel em) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OrderItemModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}