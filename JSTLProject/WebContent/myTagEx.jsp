<%@page import="kr.green.cal.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="/my-board-util.tld" %>
<%@ taglib prefix="cal" uri="/my-date-util.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="today" class="java.util.Date"/>
	날짜1 : ${my:dateFormat1(today) } <br>
	날짜2 : ${my:dateFormat2(today) } <br>
	날짜3 : ${my:dateFormat3(today) } <br>
	난수 : ${my:random() } <br>
	난수 : ${my:random()*10 } <br>
	난수 : ${my:random()*100 } <br>
	<hr>
	<c:forEach var="i" begin="1" end="10">
	로또 번호 : ${my:lotto() } <br>
	</c:forEach>
	<c:forEach var="i" begin="1" end="10">
	${cal:viewCalendar(2019, i) }
	</c:forEach>
</body>
</html>