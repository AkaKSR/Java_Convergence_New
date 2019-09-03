<%@page import="kr.green.poll.service.JsonUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// String path 설정
	String filename = request.getParameter("file");
	if(filename == null || filename.trim().length() == 0) filename = "poll";
	
	// PollVO 초기화
	PollVO vo = JsonUtil.readJSON(application.getResourceAsStream(filename + ".json"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 투표하기(복습)</title>
<style type="text/css">
table {
	width: 400px;
	margin: auto;
	border: 3px solid gray;
}

.title {
	background-color: black;
	color: white;
	font-weight: bold;
	font-size: 18pt;
	text-align: center;
	padding: 10px;
}

.sub_title {
	font-weight: bold;
	font-size: 12pt;
}

td {
	padding: 5px;
}
</style>
</head>
<body>
	<form action="pollWrite.jsp?file=<%=filename %>" method="post">
		<table>
			<tr>
				<td class="title">온라인 투표하기</td>
			</tr>
			<tr>
				<td class="sub_title"><%=vo.getSubject() %></td>
			</tr>
			<%
				for(int i = 0; i < vo.getItem().length; i++) {
			%>
			<tr>
				<td>
					<input type="radio" name="poll" value="<%=i%>" <%=(i==0 ? "checked='checked'":"") %>>
					<%=vo.getItem()[i] %>
				</td>
			</tr>
			<%}%>
			<tr align="center">
				<td>
				<input type="submit" value="투 표 하 기">
				<input type="button" value="결 과 보 기" onclick="location.href='pollResult.jsp?file=<%=filename%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>