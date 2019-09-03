<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터 파일 읽기
	InputStream is = application.getResourceAsStream("poll.json");
	List<PollVO> list = PollUtil.readPoll(is);
	// 번호가 넘어오지 않으면 보여줄 기본값
	int idx = list.size()-1; // 마지막 투표. 0이면 첫번째 투표
	try{
		// 투표 번호를 받아서 숫자로 변경
		idx = Integer.parseInt(request.getParameter("idx"));   
	}catch(Exception e){
		// 에러가 발생하면 아무것도 하지 않는다.
	}
	// 보여줄 투표를 리스트에서 가져온다.
	PollVO vo = list.get(idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 투표하기</title>
<style type="text/css">
	table {
		width: 600px; margin: auto; border: 1px solid gray;
	}
	td{ border: 0px solid gray; padding: 3px;}
	th{ border: 1px solid gray; padding: 3px; background-color: silver;}
</style>
</head>
<body>
	<form action="pollOk.jsp" method="post">
		<table>
			<tr>
				<td align="center" style="font-size: 18pt;">온라인 투표하기</td>
			</tr>	
			<tr>
				<td style="font-size: 13pt;font-weight: bold;">
				제목 : <%=vo.getSubject() %>
				<%-- idx값은 숨겨서 보내자!!! --%>
				<input type="hidden" name="idx" value="<%=idx%>">
				</td>
			</tr>	
			<%  for(int i=0;i<vo.getItem().length;i++){ %>
				<tr>
					<td>
						<label>
						<input type="radio" name="poll" value="<%=i%>"  <%=(i==0 ? "checked='checked'":"") %>>
						<%=vo.getItem()[i] %>
						</label>
					</td>
				</tr>	
			<%  } %>	
			<tr>
				<td align="center">
					<input type="submit" value="투표하기">
					<input type="button" value="결과보기" onclick="location.href='pollResult.jsp?idx=<%=idx%>'">
					<input type="button" value="목록보기" onclick="location.href='pollList.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>