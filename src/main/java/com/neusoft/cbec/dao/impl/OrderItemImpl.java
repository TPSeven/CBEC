/*package com.neusoft.cbec.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.neusoft.cbec.dao.IOrderItemDao;
import com.neusoft.cbec.model.OrderItemModel;

public class OrderItemImpl implements IOrderItemDao {
	private DataSource dataSource=null;
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(OrderItemModel em) throws Exception {
         Connection cn=dataSource.getConnection();
        String sql="insert into  ORDER_ITEM (Order_id,pro_id,pro_id_count,man_id,sorder_id,state) values (ORDER_ITEM_NEXTNO_SQ.nextval,?,?,?,?,?)";
 		PreparedStatement ps=cn.prepareStatement(sql);
 		ps.setInt(1, em.getPro_id());
 		ps.setInt(2, em.getPro_id_count());
 		ps.setInt(3, em.getMan_id());
 		ps.setInt(4,em.getSeller_id());
 		ps.setString(5,em.getState());
 		ps.executeUpdate();
 		ps.close();
 		cn.close();
	}

	@Override
	public void update(OrderItemModel em) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderItemModel em) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItemModel> selectListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemModel> selectListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItemModel selectByID(int order_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
*/