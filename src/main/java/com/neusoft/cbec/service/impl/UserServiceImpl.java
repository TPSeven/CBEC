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

	@Override
	public List<UserModel> getListWithRoleByConditionWithPage(String userName, String userSex, Date startDate,
			Date endDate, int[] roleIds, int rows, int page) throws Exception {
		return userDao.selectListWithRoleByConditionWithPage(userName, userSex, startDate, endDate, roleIds, rows, page);
	}

	//根据条件检索，统计符合条件的用户数
	@Override
	public int getCountByCondition(String userName, String userSex, Date startDate, Date endDate, int[] roleIds)
			throws Exception {
		return userDao.selectCountByCondition(userName, userSex, startDate, endDate, roleIds);
	}

	//根据检索条件，取得用户显示页数
	@Override
	public int getPageCountByCondition(String userName, String userSex, Date startDate, Date endDate, int[] roleIds,
			int rows) throws Exception {
		int total = 0;
		int count = this.getCountByCondition(userName, userSex, startDate, endDate, roleIds);
		if(count%rows==0) {
			total = count/rows;
		}else{
			total = count/rows + 1;
		}
		return total;
	}

}
