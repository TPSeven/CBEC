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
	
	@Override
	public void add(RoleModel role) throws Exception {
	}

	@Override
	public void delete(RoleModel role) throws Exception {
	}

	@Override
	public void modify(RoleModel role) throws Exception {
	}

	@Override
	public List<RoleModel> getListByAll() throws Exception {
		return roleDao.selectListByAll();
	}

	@Override
	public RoleModel getRoleById(int id) throws Exception {
		return roleDao.selectRoleById(id);
	}

}
