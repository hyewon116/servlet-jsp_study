<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>08application_setAttribute1.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>application : ServletContext : 프로젝트 1개마다 있는 저장소</h1>
		<%
			session.setAttribute("session_data", "data in session");
			application.setAttribute("app_data", "data in application");
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>