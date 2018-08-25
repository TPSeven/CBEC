package com.neusoft.cbec.model;

import org.apache.ibatis.type.Alias;

/**
 * @author Wwl 温万龙
 * 系统功能Model类
 */
@Alias("Function")
public class FunctionModel {
	
	private int no = 0; //编号
	private String name = null; //名称
	private String url = null; //功能定位地址
	
	private ModuleModel module = null; //关联属性-归属的模块

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ModuleModel getModule() {
		return module;
	}

	public void setModule(ModuleModel module) {
		this.module = module;
	}
	
}
