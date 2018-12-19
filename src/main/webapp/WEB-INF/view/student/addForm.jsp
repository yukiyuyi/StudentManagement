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
<title>Insert title here</title>
</head>
<body>
	<form action="student/add" method="post">
		学号：<input name="sno" type="text"/><br>
		姓名：<input name="sname" type="text"/><br>
		性别：<input name="ssex" type="text"/><br>
		<input type="submit" value="增加"/>
	</form>
</body>
</html>