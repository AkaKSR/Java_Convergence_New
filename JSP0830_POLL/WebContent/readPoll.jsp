<%@page import="kr.green.pool.service.JsonUtil"%>
<%@page import="kr.green.pool.vo.PollVO"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON파일 읽기</title>
</head>
<body>
	<%
		PollVO vo2 = JsonUtil.readJSON(application.getResourceAsStream("poll.json"));
		out.println(vo2 + "<br>");
	%>
</body>
</html>