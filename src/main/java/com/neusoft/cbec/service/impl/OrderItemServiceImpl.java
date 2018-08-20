/*package com.neusoft.cbec.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.neusoft.cbec.dao.IOrderItemDao;
import com.neusoft.cbec.model.OrderItemModel;
import com.nuesoft.cbec.service.IOrderItemService;
@Service
public class OrderItemServiceImpl implements IOrderItemService {

	@Override
	public void add(OrderItemModel em) throws Exception {
		String resource = "kaoliulian-config.xml";
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
		String resource = "kaoliulian-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session =sqlSessionFactory.openSession();
		IOrderItemDao orderitemDao = session.getMapper(IOrderItemDao.class);
		List<OrderItemModel> list =orderitemDao.selectListByAll();
		session.commit();
		session.close();
		return list;
	}

	@Override
	public OrderItemModel getOrderItemById(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getListWithManByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getListByCondition(int order_id, int man_id, Date startDate, Date endDate, String name)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> getListByConditionWithPage(int order_id, int man_id, Date startDate, Date endDate,
			String name, int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByCondition(int order_id, int man_id, Date startDate, Date endDate, String man_name)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPageByConditionWithPage(int order_id, int man_id, Date startDate, Date endDate, String man_name,
			int rows) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderItemModel> getListByConditionWithPage(int order_id, int man_id, Date startDate, Date endDate,
			String man_name, String state, int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByCondition(int order_id, int man_id, Date startDate, Date endDate, String man_name,
			String state) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



}*/
