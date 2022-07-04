<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- jsp에 반드시 필요한 선언 --%>
 <%-- response.setcontentType("text/html; charset=UTF-8"); --%>
 <%-- response.setCharacterEncoding("UTF-8"); --%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap,java.util.HashSet"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>01start.jsp</title> 
	</head>
	<body>
	   <%-- 01start.jsp -> 01start_jsp.java(서블릿 파일) -> 01start_jsp.class --%>
	   <%-- jsp 주석
	   	 : 여러 줄 주석 가능
	   	 : jsp는 servlet이기 때문에 jsp 주석은 client에서 보이지 않는다.
	   --%>
	   <%-- jsp의 html 코드들은 서블릿으로 변환되어 out.print("html code");로 실행된다. --%>
	   <%-- jsp 주석 추가 : 서블릿으로 변환되면서 사라지기 때문에 클라이언트에서 보이지 않음. --%>
	   <!-- html, css, javascript 주석은 클라이언트에서 보이므로 주의가 필요하다. -->
	   jsp 태그 내부에 서블릿 코딩을 한다. 
	   <h3>jsp 태그는 &lt%로 시작하고 %&gt로 끝난다.</h3>
	   <h2>&lt% jsp 서블릿 코딩 태그 %&gt</h2>
	   <h2>&lt%! jsp 멤버 변수 / 메소드 선언 태그 %&gt</h2>
	   <h1>&lt%= jsp 출력 태그 %&gt</h1>
	   <h1>&lt%@ jsp 페이지 선언 태그 %&gt</h1>
	   <h1>&lt%-- jsp 주석 태그 %&gt</h1>
	   <hr>
	   <%! String memStr = "자바 문자열 멤버 변수 선언"; %> <%-- 선언에는 ; 들어가야 함. --%>
	   <h1><%= memStr %></h1> <%-- 출력에는 ; 안 들어감 --%>
	   <%! 
	   		private String sayHello() {   // 메소드 선언 
		   		return "hi";
			}
		%>
		<h1><%= sayHello() %></h1>
		<%
			String localStr = "문자열 지역 변수";
//			private int plus(int a, int b) { //error - 메소드는 &lt! 에서 선언해라  
//				return a + b;
//			}
		%>
		<h1><%= localStr %></h1>
		<% 
			ArrayList<String> list = new ArrayList<String>();
			HashMap<String,String> map = new HashMap<String,String>();
			HashSet<String> set = new HashSet<String>();
		%>
	</body>
</html>