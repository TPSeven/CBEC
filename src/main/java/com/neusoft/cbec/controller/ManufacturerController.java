package com.neusoft.cbec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.cbec.model.ManufacturerModel;
import com.nuesoft.cbec.service.IManufacturerService;

/**
 * @author Wwl
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
}
