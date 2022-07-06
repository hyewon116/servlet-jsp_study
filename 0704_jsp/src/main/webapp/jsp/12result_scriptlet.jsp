<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>12result_scriptlet.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<%
			for(int i = 1; i <= 6; i++) {
		%>
			<h<%=i%>> Heading <%=i%> </h<%=i%>> 
		<%		
			}
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>