package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.BrandModel;
import com.nuesoft.cbec.service.IBrandService;


@RestController
@RequestMapping("/brand")
public class BrandController {

	private IBrandService brandService = null;
	
	@Autowired
	public void setBrandService(IBrandService brandService) {
		this.brandService = brandService;
	}
	
	
	@RequestMapping("/add")
	public String add(BrandModel brandmodel) throws Exception{
		brandService.add(brandmodel);
		return "ok";
	}
	
	@RequestMapping("/listbyall") 
	public List<BrandModel> toListByAl(BrandModel brandmodel) throws Exception{
		
		List<BrandModel> list = brandService.getListByAll();
		return list;
			
		
	}
	



	
	
}
