package com.neusoft.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ModuleModel;
import com.neusoft.cbec.model.RoleModel;
import com.neusoft.cbec.result.ControllerResult;
import com.nuesoft.cbec.service.IModuleService;

/**
 * @author Wwl 温万龙
 * 系统模块 控制器
 */
@RestController
@RequestMapping("/module")
public class ModuleController {
	private IModuleService moduelService = null;

	@Autowired
	public void setModuelService(IModuleService moduelService) {
		this.moduelService = moduelService;
	}
	
	// 添加系统模块
	@RequestMapping(value="/add",method= {RequestMethod.POST})
	public ControllerResult ControllerResult(ModuleModel module) throws Exception {
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			moduelService.add(module);
			result.setStatus("T");
			result.setMessage("添加模块成功");
		}catch(Exception e) {
			result.setStatus("F");
			result.setMessage("添加模块失败");
		}
		return result;
	}
	
	//修改系统模块
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public ControllerResult modify(ModuleModel module) {
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			System.out.println(module.getNo());
			moduelService.modify(module);
			result.setStatus("T");
			result.setMessage("修改模块成功");
		}catch(Exception e) {
			result.setStatus("F");
			result.setMessage("修改模块失败");
		}
		return result;
	}
	
	//删除模块
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public ControllerResult delete(ModuleModel module) {
		ControllerResult result = null;
		try {
			result = new ControllerResult();
			
			if(moduelService.isAssociation(module)) {
				result.setStatus("F");
				result.setMessage("该模块关联系统功能或用户，不能删除");
			}else {
				moduelService.delete(module);
				result.setStatus("T");
				result.setMessage("删除角色成功");
			}
		}catch(Exception e) {
			result.setStatus("F");
			result.setMessage("删除角色失败");
		}
		return result;
	}
	
	//校验模块编号 ,true:可以使用，false：不可使用
	@RequestMapping(value="/checkModuleNo",method= {RequestMethod.GET})
	public boolean checkModuleNo(@RequestParam(required=true)int no) throws Exception{
		ModuleModel module = moduelService.getModuleByNO(no);
		if(module==null) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/list",method= {RequestMethod.GET})
	// 查询系统模块列表
	public List<ModuleModel> getListByAll() throws Exception {
		return moduelService.getListByAll();
	}
	
	//根据角色id，取得对应角色
	@RequestMapping(value="/get/byNo",method= {RequestMethod.GET})
	public ModuleModel getModuleByNO(@RequestParam(required=true)int no) throws Exception{
		return moduelService.getModuleByNO(no);
	}
	
}
