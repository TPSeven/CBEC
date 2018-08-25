package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.ModuleModel;


/**
 * @author Wwl 温万龙 系统模块Dao接口
 */
public interface IModuleDao {
	
	//创建系统模块
	public void create(ModuleModel module) throws Exception;
	//更新系统模块
	public void update(ModuleModel module) throws Exception;
	//删除更新系统模块
	public void delete(ModuleModel module) throws Exception;
	//查询系统模块列表
	public List<ModuleModel> selectListByAll() throws Exception;
	//关联系统功能,查询系统模块列表
	public List<ModuleModel> selectListWithFunctionByAll() throws Exception;
	//根据编号取得系统的模块信息
	public ModuleModel selectModuleByNO(int no) throws Exception;
	
	
}
