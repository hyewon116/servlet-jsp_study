<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>03include_format.jsp</title>
	</head>
	<body>
		<%@ include file ="./header.jsp" %>
		<h1> &lt%@ include는 RequestDispatcher.include와 같다.</h1>
		<h2>include는 다른 파일을 복사해서 여기 붙이라는 표현이다. </h2>
		<%@ include file ="./footer.jsp" %>
	</body>
</html>