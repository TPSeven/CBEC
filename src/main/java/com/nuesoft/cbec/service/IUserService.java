package com.nuesoft.cbec.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.cbec.model.UserModel;

public interface IUserService {
	public void add(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void modify(UserModel user) throws Exception;
	
	public List<UserModel> getListByAll() throws Exception;
	public List<UserModel> getListByRole(int roleId) throws Exception;
	public List<UserModel> getListWithPortraitByAll() throws Exception;
	public List<UserModel> getListWithRoleByAll() throws Exception;
	public List<UserModel> getListWithRoleByCondition(String userName,String userSex,Date startDate,Date endDate,String roleName) throws Exception;
}
