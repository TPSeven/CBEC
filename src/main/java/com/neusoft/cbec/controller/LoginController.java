package com.neusoft.cbec.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.cbec.model.ModuleModel;
import com.neusoft.cbec.model.UserModel;
import com.neusoft.cbec.result.ControllerResult;
import com.nuesoft.cbec.service.IUserService;

/**
 * @author Wwl 温万龙
 * 登陆模块--控制器
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	private IUserService userService = null;
	
	@Autowired
	public void setManufacturerService(IUserService userService) {
		this.userService = userService;
	}
	
	//用户-邮箱&密码-登陆校验
	@RequestMapping(value="/validate/emailpassword",method= {RequestMethod.POST})
	public ControllerResult validate(String email,String password,HttpSession session) throws Exception {
		ControllerResult result = new ControllerResult();
		UserModel user = userService.validate(email,password);
		if(user!=null) {
			//保存会话
			session.setAttribute("user", user);
			result.setStatus("Y");
			result.setMessage("用户登陆验证成功");
		}else {
			result.setStatus("N");
			result.setMessage("用户登陆验证失败");
		}
		return result;
	}
	
	//检验是否有用户会话
	@RequestMapping(value="/checkLogin",method= {RequestMethod.GET})
	public ControllerResult checkLogin(HttpSession session)  throws Exception{
		ControllerResult result = new ControllerResult();
		if(session.getAttribute("user")!=null) {
			result.setStatus("Y");
			result.setMessage("存在用户会话");
		}else{
			result.setStatus("N");
			result.setMessage("请登录！");
		}
		return result;
	}
	
	//返回登陆了用户的信息
	@RequestMapping(value="/getLoginUser",method= {RequestMethod.GET})
	public UserModel getLoginUser(HttpSession session) {
		return (UserModel)session.getAttribute("user");
	}
	
	//用户登出
	@RequestMapping(value="/userLogout",method= {RequestMethod.GET})
	public ControllerResult userLogout(HttpSession session) {
		ControllerResult result = new ControllerResult();
		session.invalidate();
//		session.removeAttribute("user");
		result.setStatus("Y");
		result.setMessage("用户注销成功");
		return result;
	}
	

}
