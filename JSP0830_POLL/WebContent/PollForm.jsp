<%@page import="kr.green.pool.service.JsonUtil"%>
<%@page import="kr.green.pool.vo.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String filename = request.getParameter("file");
	// 파일 이름이 넘어오지 않았다면
	if (filename == null || filename.trim().length() == 0) {
		filename = "poll";
	}

	// 투표하기 파일을 객체로 읽기
	PollVO vo = JsonUtil.readJSON(application.getResourceAsStream(filename + ".json"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 투표하기</title>
<style type="text/css">
	table { width: 400px; margin: auto; border: 3px solid gray;}
	td { padding: 5px;}
	.title { 
		background-color: black; color: white; font-weight: bold; font-size: 18pt;
		text-align: center; padding: 10px;
	}
	.sub_title{ font-weight: bold; font-size: 12pt;}
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
				for(int i=0;i<vo.getItem().length;i++){
			%>
			<tr>
				<td>
					<label>
					<input type="radio"  name="poll" value="<%=i%>" <%=(i==0 ? "checked='checked'":"") %>>
					<%=vo.getItem()[i] %>
					</label>
				</td>
			</tr>
			<%  } %>
			<tr>
				<td align="center">
					<input type="submit" value=" 투 표 하 기 ">
					<input type="button" value=" 결 과 보 기 " onclick="location.href='pollResult.jsp?file=<%=filename%>&time=<%=System.currentTimeMillis() %>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>