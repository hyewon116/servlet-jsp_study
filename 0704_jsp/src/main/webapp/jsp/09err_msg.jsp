<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>09err_msg.jsp</title>
	</head>
	<body>
		<%= 
			session.getAttribute("err_msg")
		%>
	</body>
</html>