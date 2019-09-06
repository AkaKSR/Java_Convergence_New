<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>서버 정보</h1>
	<%=application.getServerInfo() %>
	<h1>버전</h1>
	<%=application.getMajorVersion() %>.<%=application.getMinorVersion()%>
	<h1>로그</h1>
	<%
	application.log("여기서 서버 버전을 출력했다.");
	System.out.println("이렇게도 로그 출력이 가능!!!");
	%>
</body>
</html>