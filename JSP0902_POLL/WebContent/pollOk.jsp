<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 한글을 받기위해
request.setCharacterEncoding("UTF-8");
// POST전송이 아닐경우(누군가가 이 파일을 직접 실행 했을 경우)
if(!request.getMethod().equals("POST")){
	// 목록 보기로 보내버린다.
	response.sendRedirect("pollList.jsp");
	return; // 이줄을 생략하면 아래줄의 명령들이 실행되어 버린다.
}
//데이터 파일 읽기
InputStream is = application.getResourceAsStream("poll.json");
List<PollVO> list = PollUtil.readPoll(is);

// 위에서 POST전송이 아닌 경우를 걸렀으므로 여기서 무조건 숫자로 변경이 가능하다.
int idx = Integer.parseInt(request.getParameter("idx"));
int poll = Integer.parseInt(request.getParameter("poll"));

// 투표가져오기
PollVO vo = list.get(idx);
// 투표한 항목 증가
vo.getCount()[poll]++;
// 다시 저장하고
PollUtil.savePoll(application.getRealPath("poll.json"), list);
// 결과보기로 간다.
response.sendRedirect("pollResult.jsp?idx=" + idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>