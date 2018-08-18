package com.neusoft.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.cbec.model.UserModel;

/**
 * @author Wwl 温万龙
 * 用户 数据库访问接口
 */
public interface IUserDao {
	public void create(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	
	//取得所有用户列表，无分页
	public List<UserModel> selectListByAll() throws Exception;
	//取得所有用户列表，有图片
	public List<UserModel> selectListWithPortraitByAll() throws Exception;
	//根据用户角色，取得相关的用户列表，无分页
	public List<UserModel> selectListByRole(int roleId) throws Exception;
	
	/*=======用户关联角色相关方法======*/
	//取得所有用户列表，关联角色，无分页
	public List<UserModel> selectListWithRoleByAll() throws Exception;
	//根据条件检索，取得用户列表，关联角色，无分页
	public List<UserModel> selectListWithRoleByCondition(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("lowerAge") int lowerAge,@Param("upperAge") int upperAge,@Param("userPhone")String userPhone,@Param("roleIds")int[] roleIds) throws Exception;
	//根据条件检索，取得用户列表，关联角色，分页
	public List<UserModel> selectListWithRoleByConditionWithPage(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("lowerAge") int lowerAge,@Param("upperAge") int upperAge,@Param("userPhone")String userPhone,@Param("roleIds")int[] roleIds,@Param("rows")int rows,@Param("page")int page) throws Exception;
	//根据条件检索，取得用户的个数
	public int selectCountByCondition(@Param("userName")String userName,@Param("userSex")String userSex,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("lowerAge") int lowerAge,@Param("upperAge") int upperAge,@Param("userPhone")String userPhone,@Param("roleIds")int[] roleIds) throws Exception;
	
}
