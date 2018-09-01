package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IRoleDao;
import com.neusoft.cbec.model.RoleModel;
import com.nuesoft.cbec.service.IRoleService;
/**
 * @author Wwl
 * 角色表 业务处理
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	public IRoleDao roleDao = null;
	
	@Autowired
	public void setManufacturerDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	//添加角色
	@Override
	public void add(RoleModel role) throws Exception {
		roleDao.create(role);
	}

	//修改角色
	@Override
	public void delete(RoleModel role) throws Exception {
		roleDao.delete(role);
	}

	@Override
	public void modify(RoleModel role) throws Exception {
	}

	//取得所有角色列表，无关联用户
	@Override
	public List<RoleModel> getListByAll() throws Exception {
		return roleDao.selectListByAll();
	}

	//根据角色id，取得对应角色
	@Override
	public RoleModel getRoleById(int id) throws Exception {
		return roleDao.selectRoleById(id);
	}

	//取得所有角色列表，关联用户
	@Override
	public List<RoleModel> getListWithUsersByAll() throws Exception {
		return roleDao.selectListWithUsersByAll();
	}
	
	//查看角色是否，关联用户
	@Override
	public boolean isAssociation(RoleModel role) {
		return roleDao.isAssociation(role)>0? true:false ;
	}

}
