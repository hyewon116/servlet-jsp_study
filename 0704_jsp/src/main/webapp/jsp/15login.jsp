<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>15login.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1> 로 그 인 </h1>
		<form id="form1" method="post" action="../Login15">
		<table class="table table-hover">
			<tbody>
				<tr>
					<td class="text-right">아이디</td>
					<td><input type="text" id="mid" name="mid"
								class="form-control" maxlength="20"
								placeholder="영문 소문자 + 숫자 6~20자"></td>
				</tr>
				<tr>
					<td class="text-right">패스워드</td>
					<td><input type="password" id="mpwd" name="mpwd"
								class="form-control" maxlength="20"
								placeholder="영문 소문자 + 숫자 6~20자"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="btn1" class="btn btn-primary btn-block">
							로 그 인
						</button>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		<%@ include file="./footer.jsp" %>

		<script type="text/javascript">
		$(document).ready(function() {
			$("#btn1").click(function() {

				if( $.trim( $("#mid").val() ) == "" ){
					alert("아이디를 확인하세요.");
					return;
				}
				if( $.trim( $("#mpwd").val() ) == "" ){
					alert("패스워드를 확인하세요.");
					return;
				}

				$("#form1").submit();
			});//click
		});//ready
		</script>

		<script type="text/javascript">
		$(document).ready(function() {
			$("#mid").keyup(function() {
				let tmp = $("#mid").val().replace( /[^ a-z 0-9 ]/g , "" );
				$("#mid").val( tmp );
			});
			$("#mpwd").keyup(function() {
				let tmp = $("#mpwd").val().replace( /[^ a-z 0-9 ]/g , "" );
				$("#mpwd").val( tmp );
			});
		});//ready
		</script>
	</body>
</html>