<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 자바의 new와 같다. MemberVO m = new MemberVO(); --%>
	<jsp:useBean id="m" class="vo.MemberVO"></jsp:useBean>
	<!--
	1개씩 받기 : jsp:setProperty태그는 setter를 호출한다.
	<jsp:setProperty property="userid" name="m"/>
	<jsp:setProperty property="name" name="m"/>
	<jsp:setProperty property="age" name="m"/>
	 -->
	 <%-- 이름이 일치하는 모든 멤버를 형변환해서 받아준다. --%>
	 <%-- jsp:setProperty는 getter를 호줄해 준다 --%>
	 <jsp:setProperty property="*" name="m"/>
	 
	이름 : <jsp:getProperty property="name" name="m"/><br>
	이름 : ${m.name }<br>
	나이 : ${m.age }세<br>
	내년 나이 : ${m.age+1 }세<br>
</body>
</html>