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
	<form action="course/update" method="post">
		旧课程号：<input name="oldCno" type="text"/><br>
		新课程号：<input name="cno" type="text"/><br>
		新课程名：<input name="cname" type="text"/><br>
		新学分：<input name="ccredit" type="text"/><br>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>