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
<title>增加成绩</title>
</head>
<body>
	<form action="grade/add" method="post">
		学号：<input name="sno" type="text"/><br>
		课程号：<input name="cno" type="text"/><br>
		成绩：<input name="score" type="text"/><br>
		<input type="submit" value="增加"/>
	</form>
</body>
</html>