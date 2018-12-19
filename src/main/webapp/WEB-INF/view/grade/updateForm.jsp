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
<title>更新成绩</title>
</head>
<body>
	<form action="grade/update" method="post">
		学 号：<input name="sno" type="text"/><br>
		课程号：<input name="cno" type="text"/><br>
		新成绩：<input name="score" type="text"/><br>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>