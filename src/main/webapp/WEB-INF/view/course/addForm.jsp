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
<title>增加课程</title>
</head>
<body>
	<form action="course/add" method="post">
		课程号：<input name="cno" type="text"/><br>
		课程名：<input name="cname" type="text"/><br>
		学分：<input name="ccredit" type="text"/><br>
		<input type="submit" value="增加"/>
	</form>
</body>
</html>