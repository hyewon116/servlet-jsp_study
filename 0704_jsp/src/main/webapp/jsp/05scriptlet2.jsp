<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>05scriptlet2.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<table border="1">
		<%
			for(int i = 1; i <= 10; i++) {
		%>
				<tr><td>
				<%= i %>
				</td></tr>
		<%
			}
		%>
		</table>
	</body>
</html>