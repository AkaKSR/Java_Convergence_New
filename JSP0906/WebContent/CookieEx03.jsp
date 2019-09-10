<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제하기</title>
</head>
<body>
	<%
		// 같은 이름으로 저장하면 전의 쿠키를 덮어 씌운다. ==> 수정
		Cookie cookie1 = new Cookie("name", "세사람");
		response.addCookie(cookie1);
		
		// 쿠키의 유효시간을 0으로 만들고 저장하면 삭제된다. ==> 삭제
		Cookie cookie2 = new Cookie("age", "22");
		cookie2.setMaxAge(0); // 유효시간 설정
		response.addCookie(cookie2);
	%>
</body>
</html>