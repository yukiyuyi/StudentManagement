<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
						+ ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href = "<%=basePath%>">
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<form action="user/add" method="post">
		用户名：<input name="username" type="text"/><br>
		密码：<input name="password" type="password"/><br>
		确认密码：<input name="passwordAgain" type="password"/><br>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>