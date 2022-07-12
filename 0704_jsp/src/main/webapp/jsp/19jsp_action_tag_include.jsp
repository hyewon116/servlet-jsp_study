<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>19jsp_action_tag_include.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<form action="<%=rootPath%>/jsp/192include.jsp"> <!-- header에 정의해놓은 rootPath 사용 -->
			<input type="text" name="txt" value="this is form data" class="form-control">
			<button type="submit" class="btn btn-info"> 전 송 </button>
		</form>
 		<%@ include file="./footer.jsp" %>
	</body>
</html>