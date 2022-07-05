<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="./11err_handling.jsp" %>  <!-- 에러 페이지 설정 방법 -->
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>11err_test.jsp</title>
	</head>
	<body>
		<!-- 의도적인 에러 발생 : errorPage로 이동 -->
		<%
			String tmp = null;
			out.print( tmp.length() );  //NullPointerException : 변수는 있는데 값은 없는 것.
		%>
	</body>
</html>