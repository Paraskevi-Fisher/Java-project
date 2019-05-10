<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body>
    <table border='1'>
    	<tr>
    		<th>花卉编号</th>
    		<th>花卉名称</th>
    		<th>价格</th>
    		<th>原产地</th>
    	</tr>
    	<c:forEach items="${list }" var="flower" >
    		<tr>
	    		<th>${flower.id }</th>
	    		<th>${flower.name }</th>
	    		<th>${flower.price }</th>
	    		<th>${flower.production }</th>
    		</tr>
    	</c:forEach>
    </table> 
    <a href="#">添加信息</a>
  </body>
</html>
