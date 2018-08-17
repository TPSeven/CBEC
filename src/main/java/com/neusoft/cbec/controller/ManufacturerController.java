package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ManufacturerModel;
import com.nuesoft.cbec.service.IManufacturerService;

/**
 * @author Wwl 温万龙
 *  员工控制器类
 */
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
	private IManufacturerService manufacturerService = null;
	
	@Autowired
	public void setManufacturerService(IManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.POST})
	public String add(ManufacturerModel manufacturer) throws Exception{
		manufacturerService.add(manufacturer);
		return "ok";
	}
	
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(ManufacturerModel manufacturer) throws Exception{
		manufacturerService.modify(manufacturer);
		return "ok";
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(ManufacturerModel manufacturer) throws Exception{
		manufacturerService.delete(manufacturer);
		return "ok";
	}
	
	@RequestMapping("/toListByAll")
	public List<ManufacturerModel> toListByAll() throws Exception{
		List<ManufacturerModel> manlist = manufacturerService.getListByAll();
		return manlist;
	}
	
	@RequestMapping("/toListWithOrderitemsByAll")
	public List<ManufacturerModel> toListWithOrderitemsByAll() throws Exception{
		List<ManufacturerModel> manlist = manufacturerService.getListWithOrderitemsByAll();
		return manlist;
	}
	
	@RequestMapping(value="/getManuById",method= {RequestMethod.POST,RequestMethod.GET})
	public ManufacturerModel getManuById(@RequestParam(required=true)int id) throws Exception{
		return manufacturerService.getManufacturerById(id);
	}
	
	@RequestMapping("/toListWithBrandsByAll")
	public List<ManufacturerModel> toListWithBrandsByAll() throws Exception{
		List<ManufacturerModel> manlist = manufacturerService.getListWithBrandsByAll();
		return manlist;
	}
	
	@RequestMapping(value="/getManuWithBrandsById",method= {RequestMethod.POST,RequestMethod.GET})
	public ManufacturerModel getManuWithBrandsById(@RequestParam(required=true)int id) throws Exception{
		return manufacturerService.getManufacturerWithBrandsById(id);
	}

	@RequestMapping(value="/getManuWithOrderById",method={RequestMethod.POST,RequestMethod.GET})
	public ManufacturerModel getManuWithOrderById(@RequestParam(required=true)int id) throws Exception{
		return manufacturerService.getManufacturerWithOrderItemById(id);
	}
}
