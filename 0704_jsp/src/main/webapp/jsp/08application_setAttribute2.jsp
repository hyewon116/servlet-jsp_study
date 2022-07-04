<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>08application_setAttribute2.jsp</title>
	</head>
	<body>
		<h1>08application_setAttribute2.jsp</h1>
		<h1>session.getAttribute("session_data") :
		 <%= session.getAttribute("session_data") %></h1>
		<h1>application.getAttribute("app_data") :
		 <%= application.getAttribute("app_data") %></h1>
	</body>
</html>