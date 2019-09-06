<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수의 저장</title>
</head>
<body>
	<%
		String var = "page 변수";
		pageContext.setAttribute("var", "pageContext 영역 변수");
		request.setAttribute("var", "request 영역 변수");
		session.setAttribute("var", "session 영역 변수");
		application.setAttribute("var", "application 영역 변수");
	%>
	저장된 영역의 변수들<br>
	page : <%=var %><br>
	pageContext : <%=pageContext.getAttribute("var") %><br>
	request : <%=request.getAttribute("var") %><br>
	session : <%=session.getAttribute("var") %><br>
	application : <%=application.getAttribute("var") %><br>
</body>
</html>