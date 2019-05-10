<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<script type="text/javascript">
		function getData() {
			var ajax;
			if (window.XMLHttpRequest)
			{
				ajax = new XMLHttpRequest();
			}
			else if (window.ActiveXObject)
			{
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			ajax.onreadystatechange = function(){
				//获取响应内容
				if (ajax.readyState==4)
				{
					if (ajax.state == 200)
					{
						var result = ajax.responseText;
						var showdiv = document.getElementById("showdiv");
						showdiv.innerHTML = result;
					}
				}

			}
			ajax.open("get","ajax");
			ajax.send(null);
		}
	</script>
	<title>Ajax</title>
</head>
<body>
	<input type="button" name="btn" onclick="getData()" value="按钮">
	<div id="showdiv">Fuck you</div>
</body>
</html>