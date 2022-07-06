<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>04parameter_send.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>jsp에서 jsp로 request.파라미터 보내기</h1>
		<h2>jsp는 서블릿이므로, 서버의 역할이 가능</h2>
		<h2>jsp는 html을 자유롭게 사용하므로, 클라이언트의 코딩을 만들 수 있다.</h2>
		 
		<form action="./04parameter_take.jsp" method="get">
			ID : <input type="text" id="mid" name="mid">
			<hr>
			PWD : <input type="password" id="mpwd" name="mpwd">
			<hr> 
			<button type="submit"> 파라미터 보내기 </button>
		</form>
		
		<%-- 지금 만든 html 코드는 
			1. 클라이언트에게 전송되어,
			2. 유저가 id/pwd 입력 후 전송 버튼을 누르면 
			3. form의 action으로 전달된다. --%>
		<%-- send 파일을 실행하면, 자동으로 take 파일이 뜸 --%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>