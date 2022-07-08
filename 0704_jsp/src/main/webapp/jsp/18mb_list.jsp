<%@page import="jsp.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>18mb_list.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %> <!-- header 파일에 loginID 객체가 만들어져 있음 -->
		<h1>Member Board 회원 전용 게시판</h1>
		<a href="<%=rootPath%>/jsp/18mb_write.jsp"> 
			<button type="button" class="btn btn-info float-right mb-1">글 쓰러 가기</button>
		</a>
		<%
			if(loginID == null || loginID.trim().length() == 0) { //header 파일에 있던 loginID 객체
				response.sendRedirect(rootPath + "/jsp/main.jsp");
				return;
			} else { 
				ArrayList<BoardDTO> list 
					= (ArrayList<BoardDTO>) request.getAttribute("member_board_list");
				if( list == null || list.size() == 0 ) {
		%>
					<h1>"조회된 데이터가 없습니다."</h1>
		<%
				} else {
					
		%>		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글 번호</th><th>제목</th><th>작성자</th><th>작성일</th>
					</tr>
				</thead>
				<tbody>
		<%
					for(int i = 0; i < list.size(); i++) { 
						BoardDTO dto = list.get(i);
		%>
					<tr>
						<td><%= dto.getBno() %></td>
						<td><%= dto.getBtitle() %></td>
						<td><%= dto.getMid() %></td>
						<td><%= dto.getBdate() %></td>
					</tr>
					
		<% 
					}
		%>	
				</tbody>
			</table>
		<%		
				}//else
			}//else
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>