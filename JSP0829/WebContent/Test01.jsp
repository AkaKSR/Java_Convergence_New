<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//이 파일을 직접 실행시키면 생년월일을 받는 페이지로 강제 이동
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("TestEx01.jsp"); // 페이지 이동
		return;
	}
	Calendar cal = Calendar.getInstance();
	// 현재 년월일 얻기
	int yy = cal.get(Calendar.YEAR);
	int mm = cal.get(Calendar.MONTH) + 1;
	int dd = cal.get(Calendar.DAY_OF_MONTH);
	int year = yy;
	int month = mm;
	int day = dd;
	System.out.println(year + ", " + month + ", " + day);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과값</title>
</head>
<body>

</body>
</html>