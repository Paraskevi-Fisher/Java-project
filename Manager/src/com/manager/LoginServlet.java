package com.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import Service.LoginService;
import Service.LoginServiceImpl;
import pojo.User;

public class LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(LoginServlet.class);
	LoginService ls = new LoginServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper = req.getParameter("oper");
		if ("login".equals(oper))
			checkUerLogin(req, resp);
		else if ("out".equals(oper))
			userOut(req, resp);
		else if ("pwd".equals(oper))
			pwd(req, resp);
		else
			logger.debug("没有找到对应的操作符："+oper);
	}
	
	private void pwd(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String newPwd = req.getParameter("newPwd");
		User user = (User) req.getSession().getAttribute("user");
		int index = ls.userChangePwdService(newPwd,user.getUid());
		logger.debug("修改密码的返回码为："+index);
	}
	
	private void userOut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession hs = req.getSession();
		hs.invalidate();
		resp.sendRedirect("/mg/login.jsp");
	}
	
	private void checkUerLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User user = ls.checkLoginService(uname, pwd);
		if (user==null)
		{
			resp.getWriter().write("用户不存在");
			return;
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("user", user);
			resp.sendRedirect("/mg/main/main.jsp");
			return;
		}
	}
}
