<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>20jsp_action_tag_forward.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<form action="<%=rootPath%>/jsp/202forward.jsp"> 
			<input type="text" name="txt" value="this is form data" class="form-control">
			<button type="submit" class="btn btn-info"> 전 송 </button>
		</form>
 		<%@ include file="./footer.jsp" %>
	</body>
</html>