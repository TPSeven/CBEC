package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.UserModel;

public interface IUserDao {
	public void create(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	
	public List<UserModel> selectListByAll() throws Exception;
	
}
