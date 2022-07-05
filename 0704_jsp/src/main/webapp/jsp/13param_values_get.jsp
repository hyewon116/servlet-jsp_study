<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>13param_values_get.jsp</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("UTF-8");//EUC-KR
			String nm = request.getParameter("nm");
			String dong = request.getParameter("dongary");
		%>
		<h1><%= nm %>님 이 선택하신 동아리는 <%= dong %>입니다.</h1>
		<h1><%= nm %>님 이 좋아하시는 과일은
		<%
			String [] fruitArr = request.getParameterValues("fruit");
			for(String str : fruitArr){
		%>
				<%= str %>
		<%
			}//for
		%>
		입니다.</h1>
		<h1><%=nm%>님이 좋아하시는 스포츠는
		<%
			String [] spoArr = request.getParameterValues("sports");
			for(String tmp : spoArr){
		%>
				<%= tmp %>
		<%
			}
		%>
		입니다.</h1>
	</body>
</html>
