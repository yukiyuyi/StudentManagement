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
<title>查询课程</title>
</head>
<body>
	<form action="course/query" method="post">
		课程号：<input name="cno" type="text"/><br>
		<input type="submit" value="查询"/>
	</form>
</body>
</html>