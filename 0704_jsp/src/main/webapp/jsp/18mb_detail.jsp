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
			
	<%
		if(loginID.equals(dto.getMid())) { //내 글일 때만 수정&삭제 가능
	%>
		<div class = "clearfix"> <!-- footer 위에 뜨게 하지 않도록 설정 -->
			<a href="<%=rootPath%>/MBList18">
				<button class="btn btn-outline-primary float-right"> 목 록 </button>
			</a>
			<a href="<%=rootPath%>/MBUform18?bno=<%=dto.getBno()%>">
				<button class="btn btn-outline-info float-right"> 게 시 글 수 정 </button>
			</a>
			<a href="<%=rootPath%>/MBDelete18?bno=<%=dto.getBno()%>">
				<button class="btn btn-outline-warning float-right"> 게 시 글 삭 제 </button>
			</a>
		</div>
		<%
			} else { //내 글이 아니어도 목록은 볼 수 있게
		%>
			<div class = "clearfix">
				<a href="<%=rootPath%>/MBList18">
				<button class="btn btn-outline-primary float-right" style="background-color:mintcream;"> 목 록 </button>
				</a>
			</div>
		<%
			}
		%>
			
		<%
				}//else
		%>		
			<%@ include file="./footer.jsp" %>
	</body>
</html>