<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>14join.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<form id="form1" method="post" action="../Join14">
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
					<td class="text-right">패스워드 확인</td>
					<td><input type="password" id="mpwdre" name="mpwdre"
								class="form-control" maxlength="20"
								placeholder="영문 소문자 + 숫자 6~20자"></td>
				</tr>
				<tr>
					<td class="text-right">전화번호</td>
					<td class="form-inline">
						<input type="text" id="tel1" name="tel1"
								class="form-control" maxlength="3"
								placeholder="010">
						-<input type="text" id="tel2" name="tel2"
								class="form-control" maxlength="4"
								placeholder="1234">
						-<input type="text" id="tel3" name="tel3"
								class="form-control" maxlength="4"
								placeholder="5678">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td class="form-inline">
						<input type="text" id="email1" name="email1"
								class="form-control" maxlength="20"
								placeholder="Your Email ID">
						@<input type="text" id="email2" name="email2"
								class="form-control" maxlength="20"
								placeholder="naver.com">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="btn1" class="btn btn-primary btn-block">
							회 원 가 입
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
				if( $.trim( $("#mid").val() ).length < 6 ){
					alert("아이디는 6자 이상이어야 합니다.");
					return;
				}
				if( $.trim( $("#mpwd").val() ) == "" ){
					alert("패스워드를 확인하세요.");
					return;
				}
				if( $.trim( $("#mpwd").val() ).length < 6 ){
					alert("패스워드는 6자 이상이어야 합니다.");
					return;
				}
				if( $.trim( $("#mpwd").val() ) != $.trim( $("#mpwdre").val() ) ){
					alert("패스워드와 패스워드 확인이 서로 다름니다.");
					return;
				}
				if( $.trim( $("#tel1").val() ) == ""
					|| $.trim( $("#tel2").val() ) == ""
					|| $.trim( $("#tel3").val() ) == "" ){
					alert("전화번호를 확인하세요.");
					return;
				}
					if( $.trim( $("#email1").val() ) == ""
						|| $.trim( $("#email2").val() ) == "" ){
					alert("이메일을 확인하세요.");
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
			$("#mpwdre").keyup(function() {
				let tmp = $("#mpwdre").val().replace( /[^ a-z 0-9 ]/g , "" );
				$("#mpwdre").val( tmp );
			});
			$("#tel1").keyup(function() {
				let tmp = $("#tel1").val().replace( /[^ 0-9 ]/g , "" );
				$("#tel1").val( tmp );
			});
			$("#tel2").keyup(function() {
				let tmp = $("#tel2").val().replace( /[^ 0-9 ]/g , "" );
				$("#tel2").val( tmp );
			});
			$("#tel3").keyup(function() {
				let tmp = $("#tel3").val().replace( /[^ 0-9 ]/g , "" );
				$("#tel3").val( tmp );
			});
			$("#email1").keyup(function() {
				let tmp = $("#email1").val().replace( /[^ a-z A-Z 0-9 ]/g , "" );
				$("#email1").val( tmp );
			});
			$("#email2").keyup(function() {
				let tmp = $("#email2").val().replace( /[^ a-z A-Z 0-9 \.]/g , "" );
				$("#email2").val( tmp );
			});
		});//ready
		</script>

	</body>
</html>