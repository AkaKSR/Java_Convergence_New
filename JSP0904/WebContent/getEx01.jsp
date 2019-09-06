<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String query = URLEncoder.encode("꽃배달", "UTF-8");
	%>
	<a href="https://search.naver.com/search.naver?query=<%=query%>">꽃배달 검색</a>
</body>
</html>