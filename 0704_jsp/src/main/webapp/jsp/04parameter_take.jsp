<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>04parameter_take.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h2>HttpServletRequest request</h2>
		<h2>HttpServletResponse response</h2>
		<h2>PrintWriter out</h2>
		<h1>jsp에서는 request, response, out 변수가 이미 준비되어 있다.</h1>
		<% 
			String id = request.getParameter("mid");  //정보를 받아서 String 객체에 담음
			String pwd = request.getParameter("mpwd"); 
		%>
		<h1> ID : <%= id %></h1>
		<h1> PWD : <%= pwd %></h1>
		
		<%-- scriptlet : jsp 코드를 분할하여 html 코드와 섞어 사용하는 방법 --%>
		<%   //if문 분할 가능
			if(id == null || id.trim().length() == 0) {
			//	out.print("<h1><a href='./04parameter_send.jsp'> 로그인 바로가기 </a></h1>");
		%>	
			<h1><a href='./04parameter_send.jsp'> 로그인 바로가기 </a></h1>
		
		<%	
			} else {
				//out.print("<h1>" + id + "님 환영합니다.</h1>");
		%>	
				<h1><%= id %> 님 환영합니다.</h1>
		<%
			}
		%>
		<%@ include file="./footer.jsp" %>
	</body>
</html>