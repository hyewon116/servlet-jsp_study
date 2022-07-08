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
						<!-- 제목을 클릭하면, 게시글 상세보기를 실행 -->
						<!-- 서버에 가서, dao를 거쳐, DBMS에서 선택된 1건의 게시글을 조회 -->
						<!-- 선택된 1건의 게시글을 조회하기 위해, 글번호를 서버로 전달해야 한다. -->
						<!-- FBList17?cmd=detail : FBList17의 doGet 메소드 내부의 detail 업무 실행 (주소가 다 보이는 건 get 방식) -->
						<a href="<%= rootPath %>/FBList17?cmd=detail&no=<%=dto.getBno()%>">  
											 <!-- ?cmd=detail&no= : ?name=value 순서. -->
							<%= dto.getBtitle() %> <!-- 제목 클릭하면 내용 볼 수 있게 a href 링크 달아줌. -->
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