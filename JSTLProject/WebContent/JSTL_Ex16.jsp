<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- request.setCharacterEncoding("UTF-8"); --%>
<fmt:requestEncoding value="UTF-8" />
<c:if test="${not empty param.locale }">
	<fmt:setLocale value="${param.locale }" />
</c:if>
<fmt:setBundle basename="message" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="COMPANY_NAME" /></title>
</head>
<body>
	<p align="right">
		[<a href="?locale=ko"> KOR</a>]
		[<a href="?locale=en"> ENG</a>]
		[<a href="?locale=jp"> JPN</a>]
	</p>
	<h1>
		<fmt:message key="COMPANY_NAME" />
	</h1>
	<fmt:message key="TITLE" />
	<br>
	<fmt:message key="GREETING" />
	<br>
	<fmt:message key="BODY" />
	<br>
	<%-- 출력이 아니라 변수에 저장 --%>
	<fmt:message key="TITLE" var="title"/>
	${title }<br>
	
	<fmt:message key="GREETING2">
		<fmt:param>admin</fmt:param>
		<fmt:param>3</fmt:param>
	</fmt:message>
</body>
</html>