package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import Service.LoginService;
import Service.LoginServiceImpl;


public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] c = req.getCookies();
		String uid = null;
		if (c!=null)
		for (int i = 0;i < c.length; i++)
		{
			if (c[i].getName().equals("uid"))
			{
				uid= c[i].getValue();
			}
		}
		
		
		
		if (uid != null)
		{
			//resp.getWriter().write(uid);
			LoginService service = new LoginServiceImpl();
			User user= service.checkUidUser(uid);
			if (user==null)
			{
				resp.sendRedirect("page");
				return;
			}
			else
			{
				HttpSession hs = req.getSession();
				hs.setAttribute("uname", user.getUname());
				resp.sendRedirect("main");
				return;
			}
		}
		else {
			resp.sendRedirect("page");
			return;
		}
	}
}
