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
<title>登陆</title>
</head>
<body>
	<form action="user/login" method="post">
		用户名：<input name="uname" type="text"/><br>
		密码：<input name="upassword" type="password"/><br>
		<input type="submit" value="登陆"/></br>
		<a href="user/addForm">注册</a>
	</form>
</body>
</html>