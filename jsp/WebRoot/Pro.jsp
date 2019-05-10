<%@ page language="java" import="java.util.*,java.lang.*" pageEncoding="utf-8"%>
<%-- 注释内容 --%>
<%!
	public String HelloWorld()
	{
		return "HelloWorld";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<title>jsp语法学习</title>
	<meta charset="utf-8">
</head>
<body>
	<h3>jsp基本语法学习</h3>
	<%=HelloWorld() %>
	<%@ include file="Static.jsp" %>
	
	<jsp:include page="Static.jsp"></jsp:include>
	<jsp:forward page="Static.jsp"></jsp:forward>
</body>
</html>