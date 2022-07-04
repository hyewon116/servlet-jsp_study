<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>05scriptlet3.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<table border="1">
		<%
			for(int i = 1; i <= 10; i++) {
		%>
				<tr>
		<%
				for(int k = 65; k <= (65 + 25); k++ ){
		%>	
					<td> <%= (char)k %> </td>
		<% 
				}//for - k
		%>
				</tr>
		<% 	
			}//for - i
		%>
		</table>
		<hr>
		<%
			for(int i = 1; i <= 10; i++) {
				for(int k = 65; k <= (65 + 25); k++ ){
					out.print((char)k);
				}//for - k
				out.print("<hr>");
			}//for - i
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>