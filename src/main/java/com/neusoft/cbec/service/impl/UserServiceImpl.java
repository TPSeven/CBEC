package com.neusoft.cbec.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IUserDao;
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
	public void add(UserModel user) throws Exception {
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
		return userDao.selectListWithRoleByAll();
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
	public List<UserModel> getListWithRoleByCondition(String userName, String userSex, Date startDate, Date endDate,
			int[] roleIds) throws Exception {
		return userDao.selectListWithRoleByCondition(userName, userSex, startDate, endDate, roleIds);
	}

}
