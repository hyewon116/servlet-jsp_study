<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>06request_setAttribute.jsp</title>
	</head>
	<body>
		<h1>jsp data의 전달 범위</h1>
		<h2>page 범위 : jsp 페이지 내부에서만 의미 있는 data 또는 변수 
					 : 해당 페이지를 벗어나면 data는 사라진다.	</h2>
		<h2>request 범위 : request 내부에서만 의미 있는 data 
						: 해당 request를 벗어나면 data는 사라진다. </h2>
		<h2>session 범위 : session 내부에서만 의미 있는 data. 
						: 해당 session을 벗어나면 data는 사라진다. </h2>
		<h2>application 범위 : WAS가 살아있는 동안 의미 있는 data
							: 서버를 끄면 data는 사라진다. </h2>
		<form action="./06request_setAttribute2.jsp">
			text data : <input type="text" id="txt" name="txt" value="text data">
			<hr>
			hidden data : <input type="hidden" id="hid" name="hid" value="hidden data">
			<hr>
			<button type="submit"> request의 범위 </button>
		</form>
	</body>
</html>