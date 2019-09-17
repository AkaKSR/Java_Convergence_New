<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formatDate</title>
</head>
<body>
	<jsp:useBean id="today" class="java.util.Date" scope="page"/>
	
	${today } <br>
	<fmt:formatDate value="${today }"/><br>
	<fmt:formatDate value="${today }" type="date"/><br>
	<fmt:formatDate value="${today }" type="time"/><br>
	<fmt:formatDate value="${today }" type="both"/><br>
	<hr />
	<fmt:formatDate value="${today }" type="date" dateStyle="full"/><br>
	<fmt:formatDate value="${today }" type="date" dateStyle="long"/><br>
	<fmt:formatDate value="${today }" type="date" dateStyle="medium"/><br>
	<fmt:formatDate value="${today }" type="date" dateStyle="short"/><br>
	<hr />
	<fmt:formatDate value="${today }" type="time" timeStyle="full"/><br>
	<fmt:formatDate value="${today }" type="time" timeStyle="long"/><br>
	<fmt:formatDate value="${today }" type="time" timeStyle="medium"/><br>
	<fmt:formatDate value="${today }" type="time" timeStyle="short"/><br>
	<hr />
	<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:formatDate value="${today }" type="both" dateStyle="long" timeStyle="long"/><br>
	<fmt:formatDate value="${today }" type="both" dateStyle="medium" timeStyle="medium"/><br>
	<fmt:formatDate value="${today }" type="both" dateStyle="short" timeStyle="short" /><br>
	<hr />
	<fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일 E"/><br>
	<fmt:formatDate value="${today }" pattern="hh시 mm분 ss.S초"/><br>
</body>
</html>