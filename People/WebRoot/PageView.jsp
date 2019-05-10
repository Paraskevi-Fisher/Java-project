<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'PageView.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table border="1px">
    	<tr>
    		<th>编号</th>
    		<th>姓名</th>
    		<th>年龄</th>
    	</tr>
   		<c:forEach items="${list }" var="peo">
   			<tr>
   				<td>${peo.id }</td>
   				<td>${peo.name }</td>
   				<td>${peo.age }</td>
   			</tr>
   		</c:forEach>
    </table>
  </body>
</html>
