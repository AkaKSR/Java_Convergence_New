<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키의 사용</title>
</head>
<body>
	<h1>모든 쿠키보기</h1>
	<%
		Cookie[] cookies = request.getCookies();
	if(cookies!=null && cookies.length>0) {
		for(Cookie cookie : cookies) {
			out.println(cookie.getName() + " : " + cookie.getValue() + "<br>");
		}
	}
	%>
</body>
</html>