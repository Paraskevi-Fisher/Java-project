<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    <script type="text/javascript" src="/myBatisP/js/JQuery.js"></script>
	<script type="text/javascript">
		$(function(){
			console.log("Hello World");
			
			$("#btn").click(function(){
				Sname = $("#Sname").val();
				Tname = $("#Tname").val();
				temp = $.ajax({url:"/myBatisP/show?Sname="+Sname+"&Tname="+Tname,
						async:false});
				console.log(temp);
				str=temp.responseText;
				json=JSON.parse(str);
				
				htmltest="";
				
				console.log(json);
				$("#show").html(json);
			});
		}
		)
		
	</script>
  </head>
  
  <body>
  	学生姓名：<input id="Sname"><br>
  	老师姓名：<input id="Tname"><br>
  	<button id="btn">提交</button>
  	<div id="show">
  		<table>
	<tr>
		<th>编号</th>
		<th>学生姓名</th>
		<th>年龄</th>
		<th>老师姓名</th>
	</tr>
	<tr>
		
	</tr>
</table>
  	</div>
  </body>
</html>
