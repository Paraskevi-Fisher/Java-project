package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import Service.LoginService;
import Service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		resp.getWriter().write(uname+":"+pwd);;
		System.out.println(uname+":"+pwd);
		
		LoginService ls = new LoginServiceImpl();
		User user = ls.checkLoginService(uname, pwd);
		System.out.println(user);
		if (user==null)
		{
			req.getRequestDispatcher("page").forward(req, resp);;
			return;
		}
		else{
			Cookie c = new Cookie("uid", user.getUid()+"");
			c.setMaxAge(24*60*60);
			c.setPath("/Login/ck");
			resp.addCookie(c);
			resp.sendRedirect("main");
			return;
		}
	}
}
