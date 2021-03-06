package com.neusoft.cbec.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IUserDao;
import com.neusoft.cbec.model.ModuleModel;
import com.neusoft.cbec.model.UserModel;
import com.nuesoft.cbec.service.IUserService;
/**
 * @author Wwl
 * 用户表 业务逻辑实现类
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	public IUserDao userDao = null;
	
	@Autowired
	public void setManufacturerDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void addWithoutPhoto(UserModel user) throws Exception {
		userDao.createWithoutPhoto(user);
	}

	//修改用户信息
	@Override
	public void modifyWithoutPhoto(UserModel user) {
		userDao.updateWithoutPhoto(user);
	}

	@Override
	public void addWithPhoto(UserModel user) throws Exception {
		userDao.createWithPhoto(user);
	}
	
	@Override
	public void delete(UserModel user) throws Exception {
	}

	@Override
	public void modify(UserModel user) throws Exception {
	}

	@Override
	public List<UserModel> getListByAll() throws Exception {
		return userDao.selectListByAll();
	}

	@Override
	public List<UserModel> getListWithRoleByAll() throws Exception {
		return userDao.selectListWithRolesByAll();
	}

	@Override
	public List<UserModel> getListWithPortraitByAll() throws Exception {
		return userDao.selectListWithPortraitByAll();
	}

	@Override
	public List<UserModel> getListByRole(int roleId) throws Exception {
		return userDao.selectListByRole(roleId);
	}

	@Override
	public List<UserModel> getListWithRoleByCondition(String userName, String userSex, Date startDate, Date endDate,int lowerAge,int upperAge,String userPhone,
			int[] roleIds) throws Exception {
		return userDao.selectListWithRoleByCondition(userName, userSex, startDate, endDate,lowerAge,upperAge,userPhone, roleIds);
	}

	@Override
	public List<UserModel> getListWithRoleByConditionWithPage(String userName, String userSex, Date startDate,Date endDate, 
			int lowerAge,int upperAge,String userPhone,int[] roleIds, int rows, int page) throws Exception {
		return userDao.selectListWithRoleByConditionWithPage(userName, userSex, startDate, endDate,lowerAge,upperAge,userPhone, roleIds, rows, page);
	}

	//根据条件检索，统计符合条件的用户数
	@Override
	public int getCountByCondition(String userName, String userSex, Date startDate, Date endDate, int lowerAge,int upperAge,String userPhone,int[] roleIds)
			throws Exception {
		return userDao.selectCountByCondition(userName, userSex, startDate, endDate,lowerAge,upperAge,userPhone,roleIds);
	}

	//根据检索条件，取得用户显示页数
	@Override
	public int getPageCountByCondition(String userName, String userSex, Date startDate, Date endDate, int lowerAge,int upperAge,String userPhone,int[] roles,
			int rows) throws Exception {
		int total = 0;
		int count = this.getCountByCondition(userName, userSex, startDate, endDate, lowerAge, upperAge, userPhone, roles);
		if(count%rows==0) {
			total = count/rows;
		}else{
			total = count/rows + 1;
		}
		return total;
	}

	//为用户授权
	@Override
	public void grantRoles(int userId, int[] addRoles) throws Exception {
		for(int roleId:addRoles) {
			userDao.grantRole(userId,roleId);
		}
	}

	//根据Id得到用户信息、关联角色
	@Override
	public UserModel getUserWithRolesById(int id) throws Exception {
		return userDao.selectUserWithRolesById(id);
	}
	
	//清空用户权限
	@Override
	public void deleteRoles(int id) {
		userDao.deleteRoles(id);
	}

	//验证用户-邮箱&密码-登陆
	@Override
	public UserModel validate(String email, String password) {
		//获取用户的权限
		return userDao.validateByEmailPassword(email,password);
	}

	//取得用户被授予的模块与功能
	@Override
	public List<ModuleModel> getGrandModulesAndFunctions(int id) {
		return userDao.selectGrandModulesAndFunctions(id);
	}

	
}
