package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IPro_photosDao;
import com.neusoft.cbec.model.Pro_PhotosModel;
import com.nuesoft.cbec.service.IPro_PhotosService;

@Service
@Transactional
public class IPro_PhotosServiceImpl implements IPro_PhotosService {
	
	private IPro_photosDao photosdao = null;
	
	@Autowired
	public void setPhotosdao(IPro_photosDao photosdao) {
		this.photosdao = photosdao;
	}

	@Override
	public void add(Pro_PhotosModel photoModel) throws Exception {
		photosdao.create(photoModel);

	}

	@Override
	public List<Pro_PhotosModel> getListWithPhotosByAll() throws Exception {
		return photosdao.selectListWithProductByAll();
	}

	@Override
	public void modify(Pro_PhotosModel photoModel) throws Exception {
		photosdao.update(photoModel);
		
	}

	@Override
	public void delete(Pro_PhotosModel photoModel) throws Exception {
		photosdao.delete(photoModel);
		
	}

}
