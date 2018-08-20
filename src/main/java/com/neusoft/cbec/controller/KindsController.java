package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.KindsModel;
import com.nuesoft.cbec.service.IKindsService;

@RestController
@RequestMapping("/kinds")
public class KindsController {
	private IKindsService kindsService = null;
	@Autowired
	public void setProdudtService(IKindsService kindsService) {
		this.kindsService = kindsService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(KindsModel kinds) throws Exception {
		
		kindsService.add(kinds);
		return "ok";
		
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(KindsModel kinds) throws Exception {
		
		kindsService.modify(kinds);
		return "ok";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(KindsModel kinds) throws Exception {
		
		kindsService.delete(kinds);
		return "ok";
		
	}
	
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<KindsModel> getListByAll() throws Exception{
		return kindsService.getListByAll();
	}
	
	@RequestMapping(value="/list/all/withproduct",method=RequestMethod.GET)
	public List<KindsModel> getListWithProductByAll() throws Exception{
		return kindsService.getListWithProductByAll();
	}
	
	@RequestMapping(value="/get/id",method=RequestMethod.GET)
	public KindsModel getById(int kindsId) throws Exception{
		return kindsService.getById(kindsId);
		
	}

}
