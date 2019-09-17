<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forTokens var="i" items="한놈,두식이,석삼,너구리,오징어,육개장,칠면조,팔보채,구아방,십장생" delims=",">
		${i }<br>
	</c:forTokens>
	<c:forTokens var="i" items="한놈,두식이-석삼/너구리,오징어-육개장/칠면조,팔보채-구아방/십장생" delims=",/-">
		${i }<br>
	</c:forTokens>
</body>
</html>