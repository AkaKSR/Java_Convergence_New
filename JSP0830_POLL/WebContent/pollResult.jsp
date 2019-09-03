<%@page import="kr.green.pool.service.JsonUtil"%>
<%@page import="kr.green.pool.vo.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String filename = request.getParameter("file");
	// 파일 이름이 넘어오지 않았다면
	if (filename == null || filename.trim().length() == 0) {
		filename = "poll";
	}
	// 투표하기 파일을 객체로 읽기
	PollVO vo = JsonUtil.readJSON(application.getResourceAsStream(filename + ".json"));
	String[] colors = "red,green,blue,brown,pink,gray".split(",");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 투표하기</title>
<style type="text/css">
table {
	width: 400px;
	margin: auto;
	border: 3px solid gray;
}

td {
	padding: 5px;
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
</style>
</head>
<body>
	<table>
		<tr>
			<td class="title">온라인 투표하기</td>
		</tr>
		<tr>
			<td class="sub_title"><%=vo.getSubject()%></td>
		</tr>
		<tr>
			<td align="right">총 투표수 : <%=vo.getTotalCount()%>표
			</td>
		</tr>
		<%
			for (int i = 0; i < vo.getItem().length; i++) {
		%>
		<tr>
			<td><%=(i + 1) + ". " + vo.getItem()[i]%> (<%=vo.getCount()[i]%>표,
				<%=vo.getPercent(i)%>)</td>
		</tr>
		<tr>
			<td>
				<hr align="left" size="10" width="<%=vo.getPercent(i)%>"
					color="<%=colors[i % vo.getCount().length]%>">
			</td>
		</tr>
		<%
			}
		%>
		<tr>
			<td align="center"><input type="button" value=" 돌 아 가 기 "
				onclick="location.href='PollForm.jsp?file=<%=filename%>'"></td>
		</tr>
	</table>
</body>
</html>
