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
			BoardDTO dto = (BoardDTO) request.getAttribute("free_board_detail"); //정보 담은 dto 가져옴.
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
				<tfoot>
					<tr>
						<td colspan="2">
							<a href="<%=rootPath%>/FBList17?cmd=uform&no=<%=dto.getBno()%>">
								<button type="button" class="btn btn-info float-right"> 
								게시글 수정 </button>
							</a>
							<a href="<%=rootPath%>/FBList17?cmd=delete&no=<%=dto.getBno()%>">
								<button type="button" class="btn btn-warning float-right"> 
								게시글 삭제 </button>
							</a>
							<a href="<%=rootPath%>/FBList17?cmd=list">
								<button type="button" class="btn btn-primary float-right"> 
								게시글 목록 </button>
							</a>
						</td>
					</tr>
				</tfoot>
			</table>
		<% 		
			}
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>