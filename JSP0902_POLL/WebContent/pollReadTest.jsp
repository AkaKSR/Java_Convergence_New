<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 스트림 얻기 : application.getResourceAsStream("poll.json");
		// 스트링 경로 : application.getRealPath("poll.json");
		InputStream is = application.getResourceAsStream("poll.json");
		
		List<PollVO> list = PollUtil.readPoll(is);
		out.println(list + "<br>");
	%>
</body>
</html>