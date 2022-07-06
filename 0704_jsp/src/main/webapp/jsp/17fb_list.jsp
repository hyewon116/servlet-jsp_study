<%@page import="jsp.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>17fb_list.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<div>
			<a href="<%=rootPath%>/jsp/17fb_write.jsp">
				<button type="button" class="btn btn-info float-right mb-1"> 글 쓰 기 </button>
			</a>
		</div>
		<%
			ArrayList<BoardDTO> list 
				= (ArrayList<BoardDTO>) request.getAttribute("free_board_list");
		if(list == null || list.size() == 0) {
		%>
			<h1>조회된 데이터가 없습니다. </h1>
		<%
		} else {
		%>
			<table class = "table table-hover">
				<thead>
					<tr>
						<th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th>
					</tr>
				</thead>
				<tbody>
		<%
			for(int i = 0; i < list.size(); i++){
				BoardDTO dto = list.get(i);
		%>
				<tr>
					<td><%= dto.getBno() %> </td>
					<td>
						<a href="<%= rootPath %>/FBList17?cmd=detail&no=<%=dto.getBno()%>"> 
						<!-- FBList17 안에 있는 cmd 값과... ? -> 주소가 다 보이는 건 get 방식. FBList17의 get 메소드 안에서 처리 --> 
							<%= dto.getBtitle() %>
						</a>
					</td>
					<td><%= dto.getBwriter() %> </td>
					<td><%= dto.getBdate() %> </td>
				</tr>
		<% 		
			}//for
		%>
				</tbody>
			</table>
		<%
		}
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>