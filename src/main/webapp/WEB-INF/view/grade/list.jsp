<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>成绩列表</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>学 号</th>
				<th>课程号</th>
				<th>成 绩</th>
			</tr>
		</thead>
		<tbody id="databody">
			<c:forEach items="${gradeList}" var="grade">
				<tr>
					<td>${grade.student.sno}</td>
					<td>${grade.course.cno}</td>
					<td>${grade.score}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a onclick="history.back()" style="color:blue;text-decoration:underline;">后退</a>
</body>
</html>