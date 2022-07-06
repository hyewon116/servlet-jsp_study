<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>06request_setAttribute2.jsp</title>
	</head>
	<body>	
		<%@ include file="./header.jsp" %>
		<h2>클라이언트에서 전달한 request data는 getParameter로 받는다.</h2>
		<h1>request.getParameter("txt") : <%= request.getParameter("txt") %></h1> 
		<h1>request.getParameter("hid") : <%= request.getParameter("hid") %></h1>
		<%
			request.setAttribute("str", new String("this is setAttribute data")); //setAttribute(이름, 내용); "str"이라는 곳에 "this is~~" 저장
			RequestDispatcher disp 
				= request.getRequestDispatcher("./06request_setAttribute3.jsp");
			disp.forward(request, response);
		//	response.sendRedirect("./06request_setAttribute3.jsp");
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>