<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String[] strings = "한놈,두식이,석삼,너구리,오징어,육개장,칠면조,팔보채,구아방,십장생".split(",");
	List<String> list = Arrays.asList(strings);

	request.setAttribute("ar", strings);
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문</title>
</head>
<body>
	<c:forEach var="i" items="${list }">
		${i } 
		<c:if test="${i ne '십장생' }">-</c:if>
	</c:forEach>
	<br>
	<hr>
	<c:forEach var="i" items="${ar }">
		${i } 
		<c:if test="${i ne '십장생' }">-</c:if>
	</c:forEach>
	<br>
	<hr>
	<c:forEach var="i" items="${ar }" begin="0" end="${fn:length(ar) }"
		step="2">
		${i } 
		<c:if test="${i ne '십장생' }">-</c:if>
	</c:forEach>
	<br>
	<hr>
	<c:forEach var="i" items="${ar }" varStatus="vs">
		${vs.index } - ${vs.count }. ${i }<br>
	</c:forEach>
	<br>
	<hr>
	<c:forEach var="i" items="${ar }" varStatus="vs" begin="3" end="8">
		${vs.index } - ${vs.count }. ${i }<br>
	</c:forEach>
	<br>
	<hr>

</body>
</html>
