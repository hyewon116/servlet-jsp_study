<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>14join_err_page.jsp</title>
	</head>
	<body>
		<h1> <%= session.getAttribute("err_msg") %> </h1>
	</body>
</html>