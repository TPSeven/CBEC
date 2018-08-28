package com.nuesoft.cbec.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.cbec.model.ModuleModel;
import com.neusoft.cbec.model.UserModel;

public interface IUserService {
	
	//添加用户，无照片
	public void addWithoutPhoto(UserModel user) throws Exception;
	//添加用户，有照片
	public void addWithPhoto(UserModel user) throws Exception;
	
	public void delete(UserModel user) throws Exception;
	public void modify(UserModel user) throws Exception;
	//修改用户信息
	public void modifyWithoutPhoto(UserModel user);
	
	//取得所有用户列表，无分页
	public List<UserModel> getListByAll() throws Exception;
	//取得所有用户列表，有图片，无分页
	public List<UserModel> getListWithPortraitByAll() throws Exception;
	//根据用户角色Id，取得所有用户列表无分页
	public List<UserModel> getListByRole(int roleId) throws Exception;
	
	/*=======用户关联角色的相关方法======*/
	//关联用户角色，取得所用用户列表，无分页
	public List<UserModel> getListWithRoleByAll() throws Exception;
	//条件检索，取得所用用户列表（关联用户角色），无分页
	public List<UserModel> getListWithRoleByCondition(String userName,String userSex,Date startDate,Date endDate,int lowerAge,int upperAge,String userPhone,int[] roleIds) throws Exception;
	//条件检索，取得所用用户列表（关联用户角色），分页
	public List<UserModel> getListWithRoleByConditionWithPage(String userName,String userSex,Date startDate,Date endDate,int lowerAge,int upperAge,String userPhone,int[] roleIds,int rows,int page) throws Exception;
	//根据条件检索，统计符合条件的用户数
	public int getCountByCondition(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("lowerAge") int lowerAge,@Param("upperAge") int upperAge,@Param("userPhone")String userPhone,@Param("roleIds")int[] roleIds) throws Exception;
	//根据检索条件，取得用户显示页数
	public int getPageCountByCondition(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("lowerAge") int lowerAge,@Param("upperAge") int upperAge,@Param("userPhone")String userPhone,@Param("roleIds")int[] roleIds,int rows) throws Exception;
	
	//为用户授权-添加角色
	public void grantRoles(int userId,int[] roleIds) throws Exception;
	//根据Id得到用户信息、关联角色
	public UserModel getUserWithRolesById(int id) throws Exception;
	//清空用户角色权限
	public void deleteRoles(int id);
	//验证用户-邮箱&密码-登陆
	public UserModel validate(String email, String password);
	//取得用户被授予的模块与功能
	public List<ModuleModel> getGrandModulesAndFunctions(int id);
	
}
