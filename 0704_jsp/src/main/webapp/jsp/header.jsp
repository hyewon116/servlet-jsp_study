<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home.html</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<div class="container"> 
			<% String rootPath = request.getContextPath(); %> <!-- 0704_jsp --> <!-- 두 번 클릭하면 생기는 오류 해결(어떻게 한거지?) -->
			<nav class="text-right">
				<%
					String loginID = (String) session.getAttribute("login_id");
					if(loginID == null || loginID.trim().length() == 0 ) {
				%>
						<a class="mr-2" href="<%=rootPath%>/jsp/15login.jsp">로그인</a>
						<a href="<%=rootPath%>/jsp/14join.jsp">회원가입</a>
				<% 
					} else {
				%>
						<a class="mr-2"><%= loginID %></a>
						<a href="../Logout16">로그아웃</a>
				<%		
					}
				%>

			</nav>
			
			<header class="jumbotron mb-2">
				<h3>coding exercise</h3>
			</header><!-- end of header -->
			<nav class="btn-group mb-2">
				<a href="<%=rootPath%>/jsp/01start.jsp">
					<button class="btn btn-primary">01start.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/02var.jsp">
					<button class="btn btn-primary">02var.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/03include_format.jsp">
					<button class="btn btn-primary">03include_format.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/04parameter_send.jsp">
					<button class="btn btn-primary">04parameter_send.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/05scriptlet1.jsp">
					<button class="btn btn-primary">05scriptlet1.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/05scriptlet2.jsp">
					<button class="btn btn-primary">05scriptlet2.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/05scriptlet3.jsp">
					<button class="btn btn-primary">05scriptlet3.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/05scriptlet4.jsp">
					<button class="btn btn-primary">05scriptlet4.jsp</button>
				</a>
			</nav><!-- end of nav -->
			<nav class="btn-group mb-2">
				<a href="<%=rootPath%>/jsp/06request_setAttribute.jsp">
					<button class="btn btn-primary">06request_setAttribute.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/07session_setAttribute1.jsp">
					<button class="btn btn-primary">07session_setAttribute1.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/08application_setAttribute1.jsp">
					<button class="btn btn-primary">08application_setAttribute1.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/08application_setAttribute2.jsp">
					<button class="btn btn-primary">08application_setAttribute2.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/09exe_search.jsp">
					<button class="btn btn-primary">09exe_search.jsp</button>
				</a>
			</nav><!-- end of nav -->
			<nav class="btn-group">
				<a href="<%=rootPath%>/jsp/10RE.jsp">
					<button class="btn btn-primary">10RE.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/11err_test.jsp">
					<button class="btn btn-primary">11err_test.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/12result_scriptlet.jsp">
					<button class="btn btn-primary">12result_scriptlet.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/13param_values.jsp">
					<button class="btn btn-primary">13param_values.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/14join.jsp">
					<button class="btn btn-primary">14join.jsp</button>
				</a>
				<a href="<%=rootPath%>/jsp/15login.jsp">
					<button class="btn btn-primary">15login.jsp</button>
				</a>
				<a href="<%=rootPath%>/Logout16">
					<button class="btn btn-primary">Logout16</button>
				</a>
				<a href="<%=rootPath%>/FBList17">
					<button class="btn btn-primary">FBList17</button>
				</a>
				<a href="<%=rootPath%>/MBList18">
					<button class="btn btn-primary">MBList18</button>
				</a>
				
			</nav><!-- end of nav -->
			<main class="mt-2">