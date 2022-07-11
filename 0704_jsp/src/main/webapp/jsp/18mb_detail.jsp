<%@page import="jsp.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>18mb_detail.jsp</title>
	</head>
	<body>
		<%@ include file="./login_check.jsp" %>
		<%@ include file="./header.jsp" %>
		<h1>Member Board 회원 전용 게시판 상세 조회</h1>
		<%
			BoardDTO dto = (BoardDTO) request.getAttribute("member_board_dto");
			if(dto == null) {
		%>
				<h1>조회된 데이터가 없습니다.</h1>
		<%
			} else {
		%>	
			<table class = "table table-hover">
				<colgroup>
					<col class="w-25">
					<col class="w-25">
					<col class="w-25">
					<col class="w-25">
				</colgroup>
				<tbody>
					<tr>
						<td>글 번호</td><td><%= dto.getBno() %></td>
						<td>제목</td><td><%= dto.getBtitle() %></td>
					</tr>
					<tr>
						<td>작성자</td><td><%= dto.getMid() %></td>
						<td>작성일시</td><td><%= dto.getBdate() %></td>
					</tr>
					<tr>
						<td>내용</td><td colspan="3"><%= dto.getBcnts() %></td>
					</tr>
				</tbody>
			</table>

	<!-- 내 글이 아니면 수정/삭제하지 못하도록 막기 -->			
	<%
		if(loginID.equals(dto.getMid())) {
	%>
		<div class = "clearfix"> <!-- footer위에 뜨게 하지 않도록 설정 -->
			<a href="<%=rootPath%>/MBUform18?bno=<%=dto.getBno()%>">
				<button class="btn btn-info float-right"> 게 시 글 수 정 </button>
			</a>
			<a href="<%=rootPath%>/MBDelete18?bno=<%=dto.getBno()%>">
				<button class="btn btn-warning float-right"> 게 시 글 삭 제 </button>
			</a>
		</div>
		<%
			}//if(loginID.equals(dto.getMid()))
		
		%>
			
		<%
				}//else
		%>		
			<%@ include file="./footer.jsp" %>
	</body>
</html>