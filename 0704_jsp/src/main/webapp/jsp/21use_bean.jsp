<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>21use_bean.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<form action="212use_bean2.jsp">
			id : <input type="text" name="mid">
			pwd : <input type="text" name="mpwd">
			tel1 : <input type="text" name="tel1">
			tel2 : <input type="text" name="tel2">
			tel3 : <input type="text" name="tel3">
			email1 : <input type="text" name="email1">
			email2 : <input type="text" name="email2">
			<button type="submit"></button>
		<%@ include file="./footer.jsp" %>
		</form>
	</body>
</html>