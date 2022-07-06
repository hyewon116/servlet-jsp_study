<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>06request_setAttribute3.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>06request_setAttribute3.jsp</h1>
		<h1>request.getParameter("txt") : <%= request.getParameter("txt") %></h1>
		<h1>request.getParameter("hid") : <%= request.getParameter("hid") %></h1>
		<h1>request.getAttribute("str") : <%= request.getAttribute("str") %></h1>
		<%@ include file="./footer.jsp" %>
	</body>
</html>