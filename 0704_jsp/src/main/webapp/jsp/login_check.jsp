<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- login_check.jsp -->

<% 
	String chkStr = (String) session.getAttribute("login_id");
	if(	chkStr == null || chkStr.trim().length() == 0 ) {
		response.sendRedirect( request.getContextPath() + "/jsp/main.jsp" );
		return;
	}
%>

<%-- 18mb_write.jsp에 include 되는 파일 --%>

<%-- header.jsp의 변수 loginID와 rootPath를 사용 --%>
<%-- header.jsp가 include된 곳에서만 사용 가능 (결합도가 높다) --%>
