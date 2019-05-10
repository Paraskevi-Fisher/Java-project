package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMethod extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String temp = req.getParameter("aihao");
		System.out.println(temp);
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(name +":"+ pwd);
	}
}
