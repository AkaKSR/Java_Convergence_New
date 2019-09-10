<%@page import="kr.green.cookie.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 테스트</title>
</head>
<body>
	<%
		// 쿠키 생성
		response.addCookie(CookieUtil.createCookie("name2", "박달봉"));
		response.addCookie(CookieUtil.createCookie("name3", "최달봉", 60 * 60 * 24 * 7));

		// 쿠키 읽기
		CookieUtil c = new CookieUtil(request);
		out.println(c + "<br>");
		
		// 쿠키 수정
		c.updateCookie(response, "name2", "박문수");
		out.println(c + "<br>");
		
		// 쿠키 삭제
		c.deleteCookie(response, "name2");
		out.println(c + "<br>");
	%>
</body>
</html>