<%@page import="jsp.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>09result_search.jsp</title>
	</head>
	<body>
		<%
			ArrayList<EmpDTO> list 
				= (ArrayList<EmpDTO>) request.getAttribute("list");
		 	if(list == null || list.size() == 0 ) {
		%>
		 		<h1> 조회된 data가 없습니다. </h1>
		<% 		
		 	} else {
		%>
		 		<table border=1>
		<% 	
		 		for(int i = 0; i < list.size(); i++ ) {
		 			EmpDTO dto = list.get(i);
		 %>
		 			<tr>
		 				<td><%= i+1 %></td>
		 				<td><%= dto.getEmpno() %></td>
		 				<td><%= dto.getEname() %></td>
		 				<td><%= dto.getJob() %></td>
		 				<td><%= dto.getMgr() %></td>
		 				<td><%= dto.getHiredate() %></td>
		 				<td><%= dto.getSal() %></td>
		 				<td><%= dto.getComm() %></td>
		 				<td><%= dto.getDeptno() %></td>
		 			</tr>
		 <%
		 		}//for
		 %>
		 		</table>
		 <%		
		 	}//else
	 	 %>
	</body>
</html>