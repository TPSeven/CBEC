package com.neusoft.cbec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wwl 温万龙
 * 登陆检查过滤器，防止重复登陆
 */
@WebFilter("*.html")
public class HtmlPageLoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("HtmlPageLoginCheckFilter 过滤器");
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		//web站点名称
		String webroot = httpRequest.getContextPath();
		//资源标识符
		String uri = httpRequest.getRequestURI();
		
		//放行登陆页面
		if(uri.equals(webroot+"/login/main.html")) {
			chain.doFilter(request, response);
		}else {
			//非登陆页面，判断是否已经登陆
			if(httpRequest.getSession().getAttribute("user")!=null) {
				chain.doFilter(request, response);
			}else {
				httpResponse.sendRedirect(webroot+"/login/main.html");
			}
		}
	}

}
