package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.RoleModel;
import com.neusoft.cbec.result.ControllerResult;
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
	
	//添加角色
	@RequestMapping(value="/add",method= {RequestMethod.POST})
	public ControllerResult add(RoleModel role) {
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			roleService.add(role);
			result.setStatus("T");
			result.setMessage("添加角色成功");
		}catch(Exception e) {
			result.setStatus("F");
			result.setMessage("添加角色失败");
		}
		return result;
	}
	
	//校验角色id ,true:可以使用，false：不可使用
	@RequestMapping(value="/checkRoleId",method= {RequestMethod.GET})
	public boolean checkRoleId(@RequestParam(required=true)int id) throws Exception{
		RoleModel role = roleService.getRoleById(id);
		if(role==null) {
			return true;
		}
		return false;
	}
	
	//修改角色
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public ControllerResult modify(RoleModel role) {
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			roleService.modify(role);
			result.setStatus("T");
			result.setMessage("修改角色成功");
		}catch(Exception e) {
			result.setStatus("F");
			result.setMessage("修改角色失败");
		}
		return result;
	}
	
	//删除角色
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public ControllerResult delete(RoleModel role) {
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			
			if(roleService.isAssociation(role)) {
				result.setStatus("F");
				result.setMessage("该角色关联用户，不能删除");
			}else {
				roleService.delete(role);
				result.setStatus("T");
				result.setMessage("删除角色成功");
			}
		}catch(Exception e) {
			result.setStatus("F");
			result.setMessage("删除角色失败");
		}
		return result;
	}
	
	//取得所有角色列表，无关联用户
	@RequestMapping(value="/list",method= {RequestMethod.GET})
	public List<RoleModel> getListByAll() throws Exception{
		List<RoleModel> rolelist = roleService.getListByAll();
		return rolelist;
	}
	
	//根据角色id，取得对应角色
	@RequestMapping(value="/get/byId",method= {RequestMethod.GET})
	public RoleModel getRoleById(@RequestParam(required=true)int id) throws Exception{
		return roleService.getRoleById(id);
	}
	
	//取得所有角色列表，关联用户
	@RequestMapping(value="/list/users",method= {RequestMethod.GET})
	public List<RoleModel> getListWithUsersByAll() throws Exception{
		return roleService.getListWithUsersByAll();
	}
	
}
