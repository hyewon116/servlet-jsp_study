<%@page import="jsp.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>17fb_detail.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		
		<%
			BoardDTO dto = (BoardDTO) request.getAttribute("free_board_detail");
			if(dto == null) {
		%>
				<h1> 조회된 데이터가 없습니다. </h1>
		<%
			} else {
		%>
			<table class = "table table-hover">
				<tbody>
					<tr><td>글번호</td><td><%= dto.getBno() %></td></tr>
					<tr><td>제목</td><td><%= dto.getBtitle() %></td></tr>
					<tr><td>작성자</td><td><%= dto.getBwriter() %></td></tr>
					<tr><td>작성일시</td><td><%= dto.getBdate() %></td></tr>
					<tr><td>내용</td><td><%= dto.getBcnts() %></td></tr>
				</tbody>
			</table>	
		<% 		
			}
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>