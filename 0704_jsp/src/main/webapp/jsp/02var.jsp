<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>02var.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>member variable</h1>
		<h2>&lt%!에서 선언된 변수는 멤버 변수가 된다.</h2>
		<h2>&lt%에서 선언된 변수는 지역 변수가 된다.</h2>
		<%! String str1 = new String("hello"); %>
		<% String str1 = new String("how are you"); %>
		<h2>멤버 변수 출력 : <%= this.str1 %></h2>
		<h2>지역 변수 출력 : <%= str1 %></h2>
		<h2>jsp 출력 태그 내부는 ;을 생략한다. </h2>
		<%@ include file="./footer.jsp" %>
	</body>
</html>