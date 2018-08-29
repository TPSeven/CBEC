package com.neusoft.cbec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Wwl 温万龙
 * 登陆检查拦截器
 */
public class LoginCheckInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("登陆检查拦截器");
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			return true;
		}else {
			String webroot = request.getContextPath();
			response.sendRedirect(webroot+"/login/main.html");
		}
		return false;
	}
}
