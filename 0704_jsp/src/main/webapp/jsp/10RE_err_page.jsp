<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>10RE_err_page.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<%-- jsp 여러 줄 주석 : 서버에서 서블릿으로 변환 시에 삭제 : 클라이언트에서 안 보임. --%>
		<h1> <%= session.getAttribute("err_msg") %> </h1>
		<%@ include file="./footer.jsp" %>
	</body>
</html>