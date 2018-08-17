package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IKindsDao;
import com.neusoft.cbec.model.KindsModel;
import com.nuesoft.cbec.service.IKindsService;

@Service
@Transactional
public class IKindsServiceImplWithSpring implements IKindsService{
	
	public IKindsDao kindsDao = null;
	
	@Autowired
	public void setKindsDao(IKindsDao kindsDao) {
		this.kindsDao = kindsDao;
	}

	@Override
	public void add(KindsModel kinds) throws Exception {
		kindsDao.create(kinds);
		
	}

	@Override
	public void modify(KindsModel kinds) throws Exception {
		kindsDao.update(kinds);
		
	}

	@Override
	public void delete(KindsModel kinds) throws Exception {
		kindsDao.delete(kinds);
		
	}

	@Override
	public List<KindsModel> getListByAll() throws Exception {
		return kindsDao.selectListByAll();
	}

	@Override
	public KindsModel getById(int kindsId) throws Exception {
		return kindsDao.selectById(kindsId);
	}

	@Override
	public List<KindsModel> getListWithProductByAll() throws Exception {
		return kindsDao.selectListWithProductByAll();
	}

}
