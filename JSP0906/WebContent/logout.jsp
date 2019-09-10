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
		// 이전페이지 알아내기!!!
		String referer = request.getHeader("referer");
		// 세션에서 회원정보를 지운다.
		session.removeAttribute("member");
		// 이전 페이지로 간다.
		response.sendRedirect(referer);
	%>
</body>
</html>