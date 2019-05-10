package Servlet;

import java.io.IOException;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ELServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname");
		uname=new String(uname.getBytes("iso8859-1"),"utf-8");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+":"+pwd);
		req.setAttribute("user", new User(uname,pwd));
		req.getRequestDispatcher("/el.jsp").forward(req, resp);
	}
}
