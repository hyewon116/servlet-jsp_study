<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>07session_setAttribute1.jsp</title>
	</head>
	<body>
		<h1>session : 서버가 클라이언트(ip+port+web browser)마다 부여하는 저장소</h1>
		<h2>invalidate(), remove(), 웹브라우저 종료의 경우에만 session 삭제된다.</h2>
		<h2>session은 request보다 넓은 개념으로 request가 종료되어도 session은 계속된다.</h2>
		<h2>page &lt request &lt session &lt application (context) </h2>
		<%
			//HttpSession session = request.getSession(); -> 이미 만들어져 있음.
			session.setAttribute("session_data1", new String("data in session"));
			session.setAttribute("session_time1", new Date().toString() );
		//	response.sendRedirect("./07session_setAttribute2.jsp"); 
		//  response.sendRedirect를 통해 request가 끊어져도, session은 살아 있다. 
			
		%>
		<h1><a href = "./07session_setAttribute2.jsp">2번으로 가기</a></h1>
	</body>
</html>