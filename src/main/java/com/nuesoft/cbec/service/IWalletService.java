package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.WalletModel;

public interface IWalletService {
	
	public void add(WalletModel wallet) throws Exception;
	public void delete(WalletModel wallet) throws Exception;
	public void modify(WalletModel wallet) throws Exception;
	
	//查询钱包列表
	public List<WalletModel> getListByAll() throws Exception;
	//根据ID查询钱包信息
	public WalletModel getWalletById(int id) throws Exception;
}
