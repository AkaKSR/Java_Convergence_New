<%@page import="kr.green.pool.vo.PollVO"%>
<%@page import="kr.green.pool.service.JsonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String filename = request.getParameter("file");
	if(filename == null || filename.trim().length() == 0) filename = "poll";
	
	PollVO vo = JsonUtil.readJSON(application.getResourceAsStream(filename + ".json"));
	
	for(int i = 0; i < vo.getCount().length; i++) {
		vo.getCount()[i] = 0;
	}
	
	JsonUtil.saveJSON(application.getRealPath(filename + ".json"), vo);
	
	response.sendRedirect("pollResult.jsp?file=" + filename);
%>