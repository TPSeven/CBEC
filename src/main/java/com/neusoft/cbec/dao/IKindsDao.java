package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.KindsModel;

/**
 * @author link
 * 品类接口
 */

public interface IKindsDao {
	//新建品种
	public void create (KindsModel kd) throws Exception;
	//修改
	public void update (KindsModel kd) throws Exception;
	//删除
	public void delete (KindsModel kd) throws Exception;
	//查询所有-无关联商品表
	public List<KindsModel> selectListByAll() throws Exception;
	//查询所有-取得关联商品表
	public List<KindsModel> selectListWithProductByAll() throws Exception;
	
	//查询所有-分页
	public List<KindsModel> selectListByAllWithPage(int rows,int page) throws Exception;
	//按编号查询
	public KindsModel selectById(int kindsId) throws Exception;
	//取得所有品种个数
	public int selectCountByAll() throws Exception;

}
