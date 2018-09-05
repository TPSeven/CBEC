package com.neusoft.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.cbec.dao.IModuleDao;
import com.neusoft.cbec.model.ModuleModel;
import com.nuesoft.cbec.service.IModuleService;

/**
 * @author Wwl 温万龙
 * 系统模块 业务实现
 */
@Service
@Transactional
public class ModuleServiceImpl implements IModuleService {
	
	private IModuleDao moduleDao = null;
	
	@Autowired
	public void setModuleDao(IModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	// 添加系统模块
	@Override
	public void add(ModuleModel module) throws Exception {
		moduleDao.create(module);
	}

	// 修改系统模块
	@Override
	public void modify(ModuleModel module) throws Exception {
		moduleDao.update(module);
	}

	@Override
	public void delete(ModuleModel module) throws Exception {
		moduleDao.delete(module);
	}

	// 查询系统模块列表
	@Override
	public List<ModuleModel> getListByAll() throws Exception {
		return moduleDao.selectListByAll();
	}

	@Override
	public List<ModuleModel> getListWithFunctionByAll() throws Exception {
		return null;
	}

	// 根据编号取得系统的模块信息
	@Override
	public ModuleModel getModuleByNO(int no) throws Exception {
		return moduleDao.selectModuleByNO(no);
	}

	// 查询是模块是否关联用户或系统功能
	@Override
	public boolean isAssociation(ModuleModel module) throws Exception {
		if(moduleDao.selectCountWithRole(module)>0 || moduleDao.selectCountWithFun(module)>0) 
			return true;
		return false;
	}

}
