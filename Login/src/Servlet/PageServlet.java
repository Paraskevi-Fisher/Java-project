package Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PageServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setAttribute("hello", "World");
		resp.getWriter().write("<html><head></head><body><form action='login' method='get'>	�û�����<input type='text' name='uname' value=''><br>	���룺<input type='password' name='pwd' value=''><br><input type='submit' value='��¼'></form></body></html>");
	}
}
