package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.UserModel;

public interface IUserService {
	public void add(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void modify(UserModel user) throws Exception;
	
	public List<UserModel> getListByAll() throws Exception;
}
