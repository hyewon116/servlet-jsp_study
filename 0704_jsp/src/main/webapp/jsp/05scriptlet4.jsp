<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>05scriptlet4.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>scriptlet을 활용하여 구구단이 들어 있는 테이블을 완성하시오.</h1>
		
		<table border="1">
		<%
		for(int dan = 2; dan <= 9; dan++) {
		%>
			<tr>
		<%
			for(int gop = 1; gop <=9; gop++) {
		%>
			<td> <%= gop %> * <%= dan %> = <%= gop * dan  %> </td>
		<% 
			}
		%>
			</tr>
		<% 
		}
		%>
		</table>
		<%@ include file="./footer.jsp" %>
	</body>
</html>