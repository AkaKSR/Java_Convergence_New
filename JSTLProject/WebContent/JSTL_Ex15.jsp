<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeZone 변경</title>
</head>
<body>
	<%	
		String[] timeZones = TimeZone.getAvailableIDs(); 
		request.setAttribute("timeZones", timeZones);
	%>
	<jsp:useBean id="today" class="java.util.Date"/>
	<c:forEach var="tz" items="${timeZones }">
		<hr>${tz }<hr>
		<!-- 
		<fmt:setTimeZone value="${tz }"/>
		-->
		<fmt:timeZone value="${tz }">
			날짜 : <fmt:formatDate value="${today }" type="date" dateStyle="full"/><br>
			시간 : <fmt:formatDate value="${today }" type="time" timeStyle="full"/><br>
		</fmt:timeZone>
	</c:forEach>
</body>
</html>



