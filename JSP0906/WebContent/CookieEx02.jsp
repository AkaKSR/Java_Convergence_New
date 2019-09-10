<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 저장해보자</title>
</head>
<body>
	<%
		Cookie cookie1 = new Cookie("name", "한사람");
		Cookie cookie2 = new Cookie("age", "33");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		out.println("저장 완료!!");
	%>
</body>
</html>