package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.KindsModel;


public interface IKindsService {
	//增加
	public void add(KindsModel kinds) throws Exception;
	//修改
	public void modify(KindsModel kinds) throws Exception;
	//删除
	public void delete(KindsModel kinds) throws Exception;
	//查询所有种类列表
	public List<KindsModel> getListByAll() throws Exception;
	//查询所有种类列表-关联商品
	public List<KindsModel> getListWithProductByAll() throws Exception;
	
	
	//按编号查询
	public KindsModel getById(int kindsId) throws Exception;
	

}
