<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>212use_bean2.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
			request.getParameter : <%= request.getParameter("mid") %>
			<hr>
			<h1>useBean 사용 : input type의 name과 DTO의 변수명이 같아야 한다. </h1> <!-- 알아서 dto에 담김. -->
			<jsp:useBean id="dto" class="jsp.MemberDTO" /> <!-- class 사용 선언 -->
			<jsp:setProperty property="*" name="dto" /> <!-- dto에 request.getParameter 수행 -->

			<jsp:getProperty property="mid" name="dto"/> <!-- dto의 mid 출력 -->
			<jsp:getProperty property="mpwd" name="dto"/> <!-- dto의 mpwd 출력 -->
			<jsp:getProperty property="tel1" name="dto"/>
			<jsp:getProperty property="tel2" name="dto"/>
			<jsp:getProperty property="tel3" name="dto"/>
			<jsp:getProperty property="email1" name="dto"/>
			<jsp:getProperty property="email2" name="dto"/>
		<%@ include file="./footer.jsp" %>
	</body>
</html>