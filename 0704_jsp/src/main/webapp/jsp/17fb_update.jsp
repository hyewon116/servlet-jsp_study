<%@page import="jsp.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>17fb_update.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<%
		BoardDTO dto = (BoardDTO) request.getAttribute("free_board_detail");
		if(dto == null) {
			response.sendRedirect(request.getContextPath() + "/FBList17?cmd=list");
		} else {
		%>
			<form id="form1" method="post" action="<%=rootPath%>/FBList17">
			<input type="hidden" name="cmd" value="update">
			<input type="hidden" name="no" value="<%=dto.getBno()%>">
			<table class="table table-hover">
				<tbody>
					<tr>
						<td>글번호</td><td><%=dto.getBno()%></td>
					</tr>
					<tr>
						<td>제목</td>
						<td>
							<input type="text" id="title" name="title" maxlength="50"
								class="form-control" value="<%=dto.getBtitle()%>">
						</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" id="writer" name="writer" maxlength="20"
								class="form-control" value="<%=dto.getBwriter()%>">
						</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea rows="10" id="cnts" name="cnts"
								class="form-control"><%=dto.getBcnts()%></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button type="button" id="btn1" class="btn btn-success float-right">
							게시글 수정 </button>
						</td>
					</tr>
				</tfoot>
			</table>
			</form>
		<%
		}
		%>
		<%@ include file="./footer.jsp" %>

		<script type="text/javascript">
		$(document).ready(function() {
			$("#btn1").click(function() {

				if( $.trim( $("#title").val() ) == "" ){
					alert("제목을 입력해 주세요.");
					return;
				}
				if( $.trim( $("#writer").val() ) == "" ){
					alert("적성자를 입력해 주세요.");
					return;
				}
				if( $.trim( $("#cnts").val() ) == "" ){
					alert("내용을 입력해 주세요.");
					return;
				}

				$("#form1").submit();
			});//click
		});//ready
		</script>
	</body>
</html>










