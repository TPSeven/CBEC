package com.neusoft.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.cbec.model.UserModel;

public interface IUserDao {
	public void create(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	
	public List<UserModel> selectListByAll() throws Exception;
	public List<UserModel> selectListByRole(int roleId) throws Exception;
	public List<UserModel> selectListWithPortraitByAll() throws Exception;
	public List<UserModel> selectListWithRoleByAll() throws Exception;
	
	public List<UserModel> selectListWithRoleByCondition(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("roleIds")int[] roleIds) throws Exception;
	public List<UserModel> selectListWithRoleByConditionWithPage(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("roleIds")int[] roleIds,@Param("rows")int rows,@Param("page")int page) throws Exception;
}
