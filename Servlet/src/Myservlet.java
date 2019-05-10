import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Myservlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,IOException
	{
		resp.getWriter().write("this is the first web project");
		System.out.println("this is the first web project");
	}
}
