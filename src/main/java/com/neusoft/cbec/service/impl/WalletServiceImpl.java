package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IWalletDao;
import com.neusoft.cbec.model.WalletModel;
import com.nuesoft.cbec.service.IWalletService;

/**
 * @author Wwl 温万龙
 * 用户钱包业务实现
 */
@Service
@Transactional
public class WalletServiceImpl implements IWalletService {
	
	private IWalletDao walletDao = null;
	
	@Autowired
	public void setWalletDao(IWalletDao walletDao) {
		this.walletDao = walletDao;
	}
	
	@Override
	public void add(WalletModel wallet) throws Exception {
	}

	@Override
	public void delete(WalletModel wallet) throws Exception {
	}

	@Override
	public void modify(WalletModel wallet) throws Exception {
	}

	@Override
	public List<WalletModel> getListByAll() throws Exception {
		return walletDao.selectListByAll();
	}

	@Override
	public WalletModel getWalletById(int id) throws Exception {
		return walletDao.selectWalletById(id);
	}

}
