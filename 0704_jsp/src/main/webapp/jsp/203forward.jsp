<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>203forward.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1><%= request.getParameter("txt") %></h1>
		<h1><%= request.getParameter("add_data1") %></h1>
		<h1><%= request.getParameter("add_data2") %></h1>
		<%@ include file="./footer.jsp" %>
	</body>
</html>