<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>13param_values.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>설문 조사</h1>
		<form method="get" action="./13param_values_get.jsp">
			이름 : <input type="text" id="nm" name="nm">
			<hr>
			동아리 하나만 선택 : 
			<input type="radio" id="dong1" name="dongary" value="soccer"> 축구
			<input type="radio" id="dong2" name="dongary" value="movie"> 영화
			<input type="radio" id="dong3" name="dongary" value="mountain"> 등산
			<hr>
			좋아하는 과일 : 
			<input type="checkbox" id="f1" name="fruit" value="apple"> 사과
			<input type="checkbox" id="f2" name="fruit" value="banana"> 바나나
			<input type="checkbox" id="f3" name="fruit" value="cherry"> 체리
			<hr>
			좋아하는 스포츠 : 
			<select multiple="multiple" id="sel1" name="sports">
				<option value="baseball">야구</option>
				<option value="volleyball">배구</option>
				<option value="basketball">농구</option>
			</select>
			<hr>
			<button type="submit"> 전 송 </button>
		</form>
		<%@ include file="./footer.jsp" %>
	</body>
</html>






