<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 태그</title>
</head>
<body>
	<c:set var="tagStr" value="나의 이름은 <b>한사람</b>입니다."/>
	${tagStr } <br>
	<c:out value="${tagStr}"/><br>
	<c:out value="${tagStr}" escapeXml="true"/><br>
	<c:out value="${tagStr}" escapeXml="false"/><br>
</body>
</html>