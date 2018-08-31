package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.ISellerDao;
import com.neusoft.cbec.model.SellerModel;
import com.nuesoft.cbec.service.ISellerService;
@Service
@Transactional
public class SellerServiceImplWithSpring implements ISellerService {
    ISellerDao sellerdao=null;
    
    
    @Autowired
	public void setSellerdao(ISellerDao sellerdao) {
		this.sellerdao = sellerdao;
	}

	@Override
	public void add(SellerModel se) throws Exception {
       sellerdao.create(se);

	}

	@Override
	public void delete(SellerModel se) throws Exception {
		   sellerdao.delete(se);

	}

	@Override
	public void modify(SellerModel se) throws Exception {
		   sellerdao.update(se);

	}

	@Override
	public List<SellerModel> getListByAll() throws Exception {
		return sellerdao.selectListByAll();  
	}

	@Override
	public SellerModel getSellerById(int seller_id) throws Exception {
		 return sellerdao.selectByID(seller_id);
	}

}
