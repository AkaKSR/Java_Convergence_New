<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 현재 시간을 얻어 오전 오후를 출력한다. --%>
	<%
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	%>
	
	시간 : <%=hour %>시<br>
	
	<%-- 표현식 만으로 출력을 한다면 --%>
	<% if(hour < 12) { %>
		오전<%=hour %>시<br>
	<% } else { %>
		오후<%=hour-12 %>시<br>
	<% } %>
	
	<%-- out 객체를 이용한 출력을 한다면 --%>
	<%
		if(hour < 12) {
			out.println("오전" + hour + "시<br>");
		} else {
			out.println("오후" + (hour-12) + "시<br>");
		}
	
		PrintWriter myOut = response.getWriter();
		myOut.println("찍히냐???");
	%>
</body>
</html>