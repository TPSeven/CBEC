package com.neusoft.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl 温万龙
 * 系统模块model类
 */
@Alias("Module")
public class ModuleModel {
	
	private int no = 0; //模块编号
	private String name = null; //模块名称
	
	private List<FunctionModel> functions = null; //关联属性-系统功能
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FunctionModel> getFunctions() {
		return functions;
	}
	public void setFunctions(List<FunctionModel> functions) {
		this.functions = functions;
	}
	
	
}
