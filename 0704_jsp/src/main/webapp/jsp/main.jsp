<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>main.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<%
		String id = (String) session.getAttribute("login_id"); //object 타입이라서 String으로 캐스팅 필요.
		if (id== null || id.trim().length() == 0) {
		%>
			<h1> <a href ="./15login.jsp"> 로그인 </a> </h1>
			<h1> <a href ="./14join.jsp"> 회원 가입 </a> </h1>
		<% 
		} else {
		%>
			<h1> <%= id %>님 반갑습니다. </h1>
			<h1> <a href="../Logout16"> 로그아웃 </a> </h1>
		<%
		}
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>