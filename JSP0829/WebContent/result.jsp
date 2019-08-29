<%@page import="kr.green.cal.DateUtil"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 이 파일을 직접 실행시키면 생년월일을 받는 페이지로 강제 이동
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("DateEx01.jsp"); // 페이지 이동
		return;
	}
	Calendar cal = Calendar.getInstance();
	// 현재 년월일 얻기
	int yy = cal.get(Calendar.YEAR); 
	int mm = cal.get(Calendar.MONTH)+1; 
	int dd = cal.get(Calendar.DAY_OF_MONTH);
	int year = yy;
	int month = mm;
	int day = dd;
	// 년월일을 받아 숫자로 변경
	try{ year = Integer.parseInt(request.getParameter("year"));} catch(Exception e){}
	try{ month = Integer.parseInt(request.getParameter("month"));} catch(Exception e){}
	try{ day = Integer.parseInt(request.getParameter("day"));} catch(Exception e){}
	// 살아온일수 = 오늘까지의 총일수 - 생일까지의 총일수  + 1
	int result = DateUtil.getTotalday(yy, mm, dd) - DateUtil.getTotalday(year, month, day) + 1; 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>당신은 <%=result %>일째 살고 있습니다.</h1>
</body>
</html>