<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStream"%>
<%@page import="kr.green.poll.vo.PollVO"%>
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
	// 제목 받기
	String subject = request.getParameter("subject");
	// 항목 받기 : name 속성 값이 같은게 여러개일 경우에는
	String[] items = request.getParameterValues("item");
	// 입력된 항목의 개수를 세어준다.
	int itemCount = 0;
	for(int i=0;i<items.length;i++){
		// 내용이 있을때만 개수를 세어준다.
		if(items[i]!=null && items[i].trim().length()>0) itemCount++;
	}
	// 입력된 개수만큼의 배열을 2개만든다.
	String[] item = new String[itemCount];
	int[] count = new int[itemCount];
	
	// 이제 배열의 내용을 채워준다. item은 항목으로 count는 0으로 채운다.
	int cnt = 0;
	for(int i=0;i<items.length;i++){
		// 내용이 있을때만 개수를 세어준다.
		if(items[i]!=null && items[i].trim().length()>0) {
			item[cnt] = items[i].trim();
			count[cnt] = 0;
			cnt++;
		}
	}
	// 이제 받은 내용으로 PollVO를 만든다.
	PollVO vo = new PollVO();
	vo.setSubject(subject);
	vo.setItem(item);
	vo.setCount(count);
	
	// 만든 VO를 리스트에 추가해서 다시 저장한다.
	// 데이터 파일 읽기
	InputStream is = application.getResourceAsStream("poll.json");
	List<PollVO> list = PollUtil.readPoll(is);
	// 추가
	list.add(vo);
	// 다시저장
	PollUtil.savePoll(application.getRealPath("poll.json"), list);
	
	// 목록으로 가자
	response.sendRedirect("pollList.jsp");
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