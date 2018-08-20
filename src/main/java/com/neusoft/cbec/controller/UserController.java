package com.neusoft.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.cbec.model.UserModel;
import com.neusoft.cbec.result.ControllerResult;
import com.neusoft.cbec.result.GridResult;
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
	
	@RequestMapping(value="/add",method= {RequestMethod.POST})
	public ControllerResult add(UserModel user,@RequestParam(required=false)MultipartFile portrait) throws Exception{
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			//无图片提交
			if(portrait==null || portrait.isEmpty()) {
				userService.addWithoutPhoto(user);
			}else{
				//有图片提交
				String fileName = portrait.getOriginalFilename();
				String contentType = portrait.getContentType();
				user.setPortrait(portrait.getBytes());
				user.setPortraitFileName(fileName);
				user.setPortraitContentType(contentType);
				userService.addWithPhoto(user);
			}
			result.setStaus("0k");
			result.setMessage("增加用户成功");
			return result;
		} catch (Exception e) {
			result.setStaus("false");
			result.setMessage(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/list")
	public List<UserModel> getListByAll() throws Exception{
		return userService.getListByAll();
	}
	
	@RequestMapping("/list/role")
	public List<UserModel> getListWithRoleByAll() throws Exception{
		return userService.getListWithRoleByAll();
	}
	
	@RequestMapping("/list/portrait")
	public List<UserModel> getListWithPortraitByAll() throws Exception{
		return userService.getListWithPortraitByAll();
	}
	
	//根据角色id，得到用户列表
	@RequestMapping(value="/list/byRole",method= {RequestMethod.POST,RequestMethod.GET})
	public List<UserModel> getListByRole(@RequestParam(required=true)int roleId) throws Exception{
		return userService.getListByRole(roleId);
	}
	
	//根据检索条件，得到用户列表
	@RequestMapping(value="/list/role/byCondition",method= {RequestMethod.GET})
	public List<UserModel> getListWithRoleByCondition(@RequestParam(required=false,defaultValue="")String userName,
			@RequestParam(required=false,defaultValue="")String userSex,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
			@RequestParam(required=false,defaultValue="0") int lowerAge,
			@RequestParam(required=false,defaultValue="0")int upperAge,
			@RequestParam(required=false,defaultValue="")String userPhone,
			@RequestParam(required=false)int[] roleIds) throws Exception{
		if(userName!=null&&userName.trim().length()>0) {
			userName = "%"+userName+"%";
		}
		if(userPhone!=null&userPhone.trim().length()>0) {
			userPhone = "%"+userPhone+"%";
		}
		return userService.getListWithRoleByCondition(userName, userSex, startDate, endDate, lowerAge, upperAge, userPhone, roleIds);
	}
	
	
	//根据检索条件，得到用户列表 分页
	@RequestMapping(value="/list/role/byCondition/page",method= {RequestMethod.GET})
	public GridResult<UserModel> getListWithRoleByConditionWithPage(@RequestParam(required=false,defaultValue="")String userName,
			@RequestParam(required=false,defaultValue="")String userSex,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date startDate,
			@RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate,
			@RequestParam(required=false)int[] roleIds,
			@RequestParam(required=false,defaultValue="0") int lowerAge,
			@RequestParam(required=false,defaultValue="0")int upperAge,
			@RequestParam(required=false,defaultValue="")String userPhone,
			@RequestParam(required=false,defaultValue="5")int rows,
			@RequestParam(required=false,defaultValue="1")int page) throws Exception{
		if(userName!=null&&userName.trim().length()>0) {
			userName = "%"+userName+"%";
		}
		if(userPhone!=null&userPhone.trim().length()>0) {
			userPhone = "%"+userPhone+"%";
		}
		
		GridResult<UserModel> gridResult = new GridResult<UserModel>();
		//总个数
		gridResult.setRecords(userService.getCountByCondition(userName, userSex, startDate, endDate, lowerAge, upperAge, userPhone, roleIds));
		int total = userService.getPageCountByCondition(userName, userSex, startDate, endDate, lowerAge, upperAge, userPhone, roleIds, rows);
		//总页数
		gridResult.setTotal(total);
		if(page<0 || page>total) {
			page = 1;
		}
		//当前页
		gridResult.setPage(page);
		
		gridResult.setRows(userService.getListWithRoleByConditionWithPage(userName, userSex, startDate, endDate, lowerAge, upperAge, userPhone, roleIds, rows, page));
		return gridResult;
	}
	
	//校验用户名是否已经注册  false：已经注册，不能被使用 ;true：没注册，能被使用 --表单变量名相同
	@RequestMapping(value="/checkNameCanBeUsed")
	public boolean checkNameCanBeUsed(String name)throws Exception {
		List<UserModel> list =  userService.getListByAll();
		for(UserModel user : list) {
			if(user.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
	
	//校验邮箱是否已经注册   false：已经注册，不能被使用 ;true：没注册，能被使用 --表单变量名不相同
	@RequestMapping(value="/checkEmailCanBeUsed",method= {RequestMethod.POST})
	public boolean checkEmailCanBeUsed(String userEmail)throws Exception {
		List<UserModel> list =  userService.getListByAll();
		for(UserModel user : list) {
			if(user.getEmail().equals(userEmail)) {
				return false;
			}
		}
		return true;
	}
	
}
