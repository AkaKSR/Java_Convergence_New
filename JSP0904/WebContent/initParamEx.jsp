<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// web.xml에 저장되어있는 변수값 읽기
	String userid = application.getInitParameter("userid");
	String password = application.getInitParameter("password");
	
	// 서버의 실제 경로 얻기
	String path = application.getRealPath("/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사용자 아이디 : <%=userid %><br>
	사용자 비밀번호 : <%=password %><br>
	서버 실제경로 : <%=path %><br>
	<h1>모든 초기화 파라메터 읽기</h1>
	<%
		Enumeration<String> em = application.getInitParameterNames();
		while(em.hasMoreElements()) {
			String var = em.nextElement();
			String value = application.getInitParameter(var);
			out.println(var + " : " + value + "<br>");
		}
	%>
</body>
</html>