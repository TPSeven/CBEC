package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(BrandModel brandmodel) throws Exception{
		brandService.add(brandmodel);
		return "ok";
	}
	
	@RequestMapping(value = "/listbyall",method = RequestMethod.GET) 
	public List<BrandModel> toListByAl() throws Exception{
		
		List<BrandModel> list = brandService.getListByAll();
		return list;	
	}
	
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public String modify(BrandModel brandmodel)throws Exception{
		brandService.modify(brandmodel);
		return "ok";
	}
	
	@RequestMapping(value="/getbrandid",method = {RequestMethod.POST ,RequestMethod.GET})
	public BrandModel getbrandid(@RequestParam(required=true)int id) throws Exception{
		return brandService.getById(id);
	}		



	
	
}
