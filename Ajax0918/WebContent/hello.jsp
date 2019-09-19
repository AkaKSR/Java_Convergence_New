<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	int age = 0;
	try {
		age = Integer.parseInt(request.getParameter("age"));
	} catch(Exception e) {
		;
	}
	if(age<20) {
		out.println(name + "씨 미자였네? 껒영");
	} else {
		out.println(name + "씨 어른이네? 드루와");
	}
%>