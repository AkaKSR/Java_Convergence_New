<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// referer 생성
	String referer = request.getHeader("referer");
	// 세션에서 회원정보 삭제
	session.removeAttribute("member");
	// refere Redirect
	response.sendRedirect(referer);
%>