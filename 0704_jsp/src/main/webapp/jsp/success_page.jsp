<%@page import="jsp.SuccessMsgDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>success_page.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<% 
			SuccessMsgDTO dto 
				= (SuccessMsgDTO) session.getAttribute("success_msg_dto");
			if (dto == null) {
				response.sendRedirect("./main.jsp");
			}
		%>
		<h1><%= dto.getMessage() %> </h1>
		<a href="<%= dto.getUrl() %>"> <%= dto.getUrlName() %> </a>
		<%@ include file="./footer.jsp" %>
	</body>
</html>