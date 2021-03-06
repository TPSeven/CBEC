package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.RoleModel;

public interface IRoleService {
	public void add(RoleModel role) throws Exception;
	public void delete(RoleModel role) throws Exception;
	public void modify(RoleModel role) throws Exception;
	
	public List<RoleModel> getListByAll() throws Exception;
	public List<RoleModel> getListWithUsersByAll() throws Exception;
	public RoleModel getRoleById(int id) throws Exception;
	//查看角色是否关联用户
	public boolean isAssociation(RoleModel role);
}
