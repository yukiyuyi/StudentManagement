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
<base href = "<%=basePath %>">
<meta charset = "UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="student/addForm">增加学生</a>
	<a href="student/deleteForm">删除学生</a>
	<a href="student/updateForm">修改学生</a>
	<a href="student/queryForm">查询学生</a>
	<a href="student/queryAll">查询所有学生</a></br>
	
	<a href="course/addForm">增加课程</a>
	<a href="course/deleteForm">删除课程</a>
	<a href="course/updateForm">修改课程</a>
	<a href="course/queryForm">查询课程</a>
	<a href="course/queryAll">查询所有课程</a></br>
	
	<a href="grade/addForm">增加成绩</a>
	<a href="grade/deleteForm">删除成绩</a>
	<a href="grade/updateForm">修改成绩</a>
	<a href="grade/queryForm">查询成绩</a>
	<a href="grade/queryAll">查询所有成绩</a></br>
</body>
</html>