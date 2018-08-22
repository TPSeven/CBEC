package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.WalletModel;


/**
 * @author Wwl 温万龙
 * 钱包Dao层接口
 */
public interface IWalletDao {
	public void create(WalletModel wallet) throws Exception;
	public void delete(WalletModel wallet) throws Exception;
	public void update(WalletModel wallet) throws Exception;
	
	//查询钱包列表
	public List<WalletModel> selectListByAll() throws Exception;
	//根据ID查询钱包信息
	public WalletModel selectWalletById(int id) throws Exception;
	
}
