<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="kr.green.poll.service.JsonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String filename = request.getParameter("file");
	if(filename == null || filename.trim().length() == 0) filename = "poll";
	
	// POST 전송이 아니면 투표하기 폼으로 이동
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("PollForm.jsp?file=" + filename);
	}
	
	// 투표하기 파일을 객체로 읽기
	PollVO vo = JsonUtil.readJSON(application.getResourceAsStream(filename + ".json"));
	// 몇번을 투표했는지 읽어서 숫자로 변환
	int i = Integer.parseInt(request.getParameter("poll"));
	// 투표한 번호의 숫자를 1 증가 시킨다.
	vo.getCount()[i]++;
	// 다시 객체를 JSON파일로 저장
	JsonUtil.saveJSON(application.getRealPath(filename + ".json"), vo);
	// 결과보기로 이동
	response.sendRedirect("pollResult.jsp?file=" + filename);
%>