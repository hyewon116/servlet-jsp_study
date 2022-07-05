<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>10RE.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<!-- ../ : 현재 폴더의 상위 폴더 = "http://localhost:8080/0704_jsp/RE10" -->
		<form action="../RE10" method="get" target="_blank"> <!-- target="_blank" : 버튼 클릭했을 때 새창으로 뜨도록!! -->
			이름 검색 : <input type="text" id="ename" name="ename">
			<hr>
			<button type="submit"> S E A R C H </button>
		<%@ include file="./footer.jsp" %>
		</form>
	</body>
</html>