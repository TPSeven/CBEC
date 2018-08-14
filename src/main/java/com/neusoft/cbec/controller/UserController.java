package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<UserModel> userlist = userService.getListByAll();
		return userlist;
	}
}
