package com.neusoft.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.UserModel;
import com.nuesoft.cbec.service.IUserService;


/**
 * @author Wwl
 * 用户表 控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {
	private IUserService userService = null;
	
	@Autowired
	public void setManufacturerService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/getListByAll")
	public List<UserModel> getListByAll() throws Exception{
		return userService.getListByAll();
	}
	
	@RequestMapping("/getListWithRoleByAll")
	public List<UserModel> getListWithRoleByAll() throws Exception{
		return userService.getListWithRoleByAll();
	}
	
	@RequestMapping("/getListWithPortraitByAll")
	public List<UserModel> getListWithPortraitByAll() throws Exception{
		return userService.getListWithPortraitByAll();
	}

	@RequestMapping(value="/getListByRole",method= {RequestMethod.POST,RequestMethod.GET})
	public List<UserModel> getListByRole(@RequestParam(required=true)int roleId) throws Exception{
		return userService.getListByRole(roleId);
	}
	
	@RequestMapping(value="/getListWithRoleByCondition",method= {RequestMethod.GET})
	public List<UserModel> getListWithRoleByCondition(@RequestParam(required=false,defaultValue="")String userName,
			@RequestParam(required=false,defaultValue="")String userSex,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
			@RequestParam(required=false,defaultValue="")String roleName) throws Exception{
		if(userName!=null&&userName.trim().length()>0) {
			userName = "%"+userName+"%";
		}
		if(roleName!=null&&roleName.trim().length()>0) {
			roleName = "%"+roleName+"%";
		}
		return userService.getListWithRoleByCondition(userName, userSex, startDate, endDate, roleName);
	}
}
