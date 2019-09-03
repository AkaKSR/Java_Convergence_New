<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 데이터 파일 읽기
InputStream is = application.getResourceAsStream("poll.json");
List<PollVO> list = PollUtil.readPoll(is);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 목록 보기</title>
<style type="text/css">
	table {
		width: 600px; margin: auto; border: 0px solid gray;
	}
	td{ border: 1px solid gray; padding: 3px;}
	th{ border: 1px solid gray; padding: 3px; background-color: silver;}
</style>
</head>
<body>
<table border="1">
	<tr>
		<td align="center" colspan="4" style="font-size:18pt; border: 0px solid gray;">
		온라인 설문조사 목록 보기
		</td>
	</tr>
	<tr>
		<td align="right" colspan="4" style="border: 0px solid gray;">
			설문개수 : <%=list.size() %>개
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>설문지 제목</th>
		<th>총 투표수</th>
		<th>처리</th>
	</tr>
	<%-- 개수만큼 반복문으로 거꾸로 돌려준다. --%>
	<% 
		for(int i=list.size()-1;i>=0;i--){
			PollVO vo = list.get(i);
	%>
		<tr align="center">
			<td width="10%"><%=(i+1) %></td>
			<td width="60%" align="left">
				<a href="pollView.jsp?idx=<%=i%>"><%=vo.getSubject() %></a>
			</td>
			<td><%=vo.getTotalCount() %></td>
			<td>
				<button onclick="location.href='pollResult.jsp?idx=<%=i%>'">결과보기</button>
			</td>
		</tr>
	<% } %>
		<tr>
		<td align="right" colspan="4" style="border: 0px solid gray;">
			<button onclick="location.href='pollInsert.jsp'" >투표 등록</button>
		</td>
	</tr>
</table>
</body>
</html>