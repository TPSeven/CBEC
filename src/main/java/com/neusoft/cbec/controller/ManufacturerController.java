package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.cbec.model.ManufacturerModel;
import com.nuesoft.cbec.service.IManufacturerService;

/**
 * @author Wwl 温万龙
 *  员工控制器类
 */
@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {
	private IManufacturerService manufacturerService = null;
	
	@Autowired
	public void setManufacturerService(IManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}
	
	@RequestMapping("/add")
	public String add(ManufacturerModel manufacturer) throws Exception{
		manufacturerService.add(manufacturer);
		return "ok";
	}
	
	@RequestMapping("/toListByAll")
	@ResponseBody
	public List<ManufacturerModel> toListByAll() throws Exception{
		List<ManufacturerModel> list = manufacturerService.getListByAll();
		return list;
	}
}
