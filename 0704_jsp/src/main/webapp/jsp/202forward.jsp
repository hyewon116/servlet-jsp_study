<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>202forward.jsp</title>
	</head>
	<body>
		<jsp:forward page="./203forward.jsp">
			<jsp:param value="010-9999-8888" name="add_data1" />
			<jsp:param value="abcd@naver.com" name="add_data2" />
		</jsp:forward>
	</body>
</html>