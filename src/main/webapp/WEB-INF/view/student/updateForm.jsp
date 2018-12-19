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
	<form action="student/update" method="post">
		旧学号：<input name="oldSno" type="text"/><br>
		新学号：<input name="sno" type="text"/><br>
		新姓名：<input name="sname" type="text"/><br>
		新性别：<input name="ssex" type="text"/><br>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>