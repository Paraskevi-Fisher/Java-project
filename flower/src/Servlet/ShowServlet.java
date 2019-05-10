package Servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.flower;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Service fs = new Service();
		List<flower>list = new ArrayList<flower>();
		list.add(new flower(1, "������ڻ�", 2.5, "�߹�"));
		list.add(new flower(2, "����С�ڻ�", 3.5, "����"));
		req.setAttribute("list", list);
		req.getRequestDispatcher("flower.jsp").forward(req, resp);
		return;
	}
}
