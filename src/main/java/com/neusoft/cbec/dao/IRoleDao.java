package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.RoleModel;

public interface IRoleDao {
	public void create(RoleModel role) throws Exception;
	public void delete(RoleModel role) throws Exception;
	public void update(RoleModel role) throws Exception;
	
	public List<RoleModel> selectListByAll() throws Exception;
	public RoleModel selectRoleById(int id) throws Exception;
}
