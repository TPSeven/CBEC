package com.neusoft.cbec.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IProductDao;
import com.neusoft.cbec.model.ProductModel;
import com.nuesoft.cbec.service.IProductService;


@Service
@Transactional
public class ProductServiceImplWithSpring implements IProductService {
	
	public IProductDao productDao = null;
	
	@Autowired
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void add(ProductModel product) throws Exception {
		productDao.create(product);
	}

	@Override
	public void modify(ProductModel product) throws Exception {
		productDao.update(product);

	}

	@Override
	public void delete(ProductModel product) throws Exception {
		productDao.delete(product);

	}

	@Override
	public List<ProductModel> getListByAll() throws Exception {
		
		return productDao.selectListByAll();
	}

	@Override
	public ProductModel getById(String productId) throws Exception {
		
		return productDao.selectById(productId);
	}
	

	//取得所有商品列表-无关联种类-无分页
	@Override
	public List<ProductModel> getListWithoutKindsByAll() throws Exception {
		
		return productDao.selectListWithoutKindsByAll();
	}

	//取得所有商品列表-有关联种类-无分页
	@Override
	public List<ProductModel> getListWithKindsByAll() throws Exception {
		return productDao.selectListWithKindsByAll();
	}

	@Override
	public List<ProductModel> getListByCondition(int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state) throws Exception {
		
		return productDao.selectListByCondition(kindsId, sprice, eprice, brand, startDate, endDate, name, state);
	}

	@Override
	public List<ProductModel> getListByConditionWithPage(int brandId,int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state, int rows, int page) throws Exception {
		return productDao.selectListByConditionWithPage(brandId,kindsId, sprice, eprice, brand, startDate, endDate, name, state, rows*(page-1)+1, rows*page);
	}

	@Override
	public int getCountByCondition(int brandId,int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state)
			throws Exception {
		return productDao.selectCountByCondition(brandId,kindsId, sprice, eprice, brand, startDate, endDate, name, state);
	}

	@Override
	public int getPageCountByCondition(int brandId,int kindsId,int sprice,int eprice,int brand,Date startDate,Date endDate,String name, String state,
			int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(brandId,kindsId, sprice, eprice, brand, startDate, endDate, name, state);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		
		return pageCount;
	}

	@Override
	public ProductModel getByIdWithKinds(String productId) throws Exception {
		
		return productDao.selectByIdWithKinds(productId);
	}

	@Override
	public ProductModel getByIdWithKindsAndBrand(String productId) throws Exception {
		return productDao.selectByIdWithKindsAndBrand(productId);
	}

	

}
