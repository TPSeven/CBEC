package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.RoleModel;
import com.nuesoft.cbec.service.IRoleService;


/**
 * @author Wwl
 * 角色表控制层
 */
@RestController
@RequestMapping("/role")
public class RoleController {
	private IRoleService roleService = null;
	
	@Autowired
	public void setManufacturerService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping("/getListByAll")
	public List<RoleModel> getListByAll() throws Exception{
		List<RoleModel> rolelist = roleService.getListByAll();
		return rolelist;
	}
	
	@RequestMapping(value="/getRoleById",method= {RequestMethod.POST,RequestMethod.GET})
	public RoleModel getRoleById(@RequestParam(required=true)int id) throws Exception{
		return roleService.getRoleById(id);
	}
}
