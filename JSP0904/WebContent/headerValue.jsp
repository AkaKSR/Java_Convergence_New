<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTTP 헤더 정보 값 얻기</title>
</head>
<body>
	host :
	<%=request.getHeader("host")%><br>
	<h1>모든 헤더 정보 보기</h1>
	<%
		Enumeration<String> em = request.getHeaderNames();
		while (em.hasMoreElements()) {
			String headerName = em.nextElement();
			//String headerValue = request.getHeader(headerName);
			out.println("<hr>" + headerName + "<br><hr>");
			Enumeration<String> values = request.getHeaders(headerName);
			while (values.hasMoreElements()) {
				out.println(values.nextElement() + "<br><hr>");
			}
		}
	%>
</body>
</html>