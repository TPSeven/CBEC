package com.nuesoft.cbec.service;

import java.util.List;

import com.neusoft.cbec.model.ModuleModel;

/**
 * @author Wwl 温万龙
 * 系统模块 业务接口
 */
public interface IModuleService {
	// 添加系统模块
	public void add(ModuleModel module) throws Exception;

	// 修改系统模块
	public void modify(ModuleModel module) throws Exception;

	// 删除更新系统模块
	public void delete(ModuleModel module) throws Exception;

	// 查询系统模块列表
	public List<ModuleModel> getListByAll() throws Exception;

	// 关联系统功能,查询系统模块列表
	public List<ModuleModel> getListWithFunctionByAll() throws Exception;

	// 根据编号取得系统的模块信息
	public ModuleModel getModuleByNO(int no) throws Exception;
	
	// 查询是模块是否关联用户或系统功能
	public boolean isAssociation(ModuleModel module) throws Exception;
}
