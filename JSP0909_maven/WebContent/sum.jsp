<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 이 파일에는 자바 코드만으로 만든다. 비즈니스 로직을 처리한다.
	int sum = 0;
	for(int i = 1; i <= 100; i++) {
		sum += i;
	}
	// 처리 결과를 page, request, session, application 영역에 저장하고
	request.setAttribute("sum", sum);
	// html만 있는 페이지로 포워딩한다.
	pageContext.forward("sumView.jsp");
%>