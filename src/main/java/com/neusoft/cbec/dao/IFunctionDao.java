package com.neusoft.cbec.dao;

import java.util.List;

import com.neusoft.cbec.model.FunctionModel;

/**
 * @author Wwl 温万龙
 * 系统功能Dao类
 */
public interface IFunctionDao {
	//创建系统功能
	public void create(FunctionModel function) throws Exception;
	//更新系统功能
	public void update(FunctionModel function) throws Exception;
	//删除更新系统功能
	public void delete(FunctionModel function) throws Exception;
	//查询系统功能列表
	public List<FunctionModel> selectListByAll() throws Exception;
	//关联归属的模块,查询系统功能列表
	public List<FunctionModel> selectListWithFunctionByAll() throws Exception;
	//根据编号取得系统的功能信息
	public FunctionModel selectFunctionByNO(int no) throws Exception;
}
