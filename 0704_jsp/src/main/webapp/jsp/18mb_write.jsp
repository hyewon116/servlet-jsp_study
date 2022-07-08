<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>18mb_write.jsp</title>
		<script src="//cdn.ckeditor.com/4.19.0/full/ckeditor.js"></script>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>Member Board 회원 전용 게시판 글쓰기</h1>
		<form id="form1" action="<%=rootPath%>/MBWrite18" method="post"> <!-- get 방식은 양이 많으면 오류날 확률 높. 이 파일은 post 방식이 적절 -->
		<table class="table table-hover">
			<tbody>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="title" name="title" maxlength="50"
								class="form-control">
					</td>
				</tr>
				<!-- 로그인한 유저가 쓰는 게시판이라 작성자란은 없음! (작성자 자동 생성) -->
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="10" id="cnts" name="cnts"
								class="form-control"></textarea>
						<script type="text/javascript">
						CKEDITOR.replace('cnts');
						</script>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="btn1"
							class="btn btn-success float-right"> 등 록 </button> <!-- 등록 버튼!! 로직의 시작!! -->
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		<%@ include file="./footer.jsp" %>
		
		<script type="text/javascript">
		$(document).ready(function() {
			$("#btn1").click(function() {
				if( $.trim( $("#title").val() ) == "") {
					alert("제목을 입력하세요.");
					return;
				}
				if( $.trim( $("#cnts").val() ) == "") {
					alert("내용을 입력하세요.");
					return;
				}
				$("#form1").submit(); //다 입력됐으면 제출됨. 위 form의 action 주소로.
			});//click
		});//ready
		</script>
	</body>
</html>