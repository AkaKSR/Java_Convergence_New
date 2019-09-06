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
	<jsp:include page="top.jsp">
		<jsp:param value='<%=URLEncoder.encode("최씨", "UTF-8")%>' name="name" />
	</jsp:include>
	<hr>
	나는 페이지 3입니다.......
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>