package Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String uname = "";
		HttpSession hs = req.getSession();
		uname= (String) hs.getAttribute("uname");
		resp.getWriter().write("»¶Ó­µÇÂ½£¬"+uname);
		ServletConfig sc = this.getServletConfig();
		String code=sc.getInitParameter("config");
		resp.getWriter().write(code);
	}
}
