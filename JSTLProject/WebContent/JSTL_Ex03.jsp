<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문</title>
</head>
<body>
	<c:if test="${empty param.num1}">
		${pageContext.request.requestURI }?num1=10 으로 실행하세요.<br>
	</c:if>
	<c:if test="${param.num1 eq 0}">
		${param.num1 }은 0입니다.
	</c:if>
	<c:if test="${param.num1 gt 0}">
		${param.num1 }은 양수입니다.
	</c:if>
	<c:if test="${param.num1 lt 0}">
		${param.num1 }은 음수입니다.
	</c:if>
	
	<c:choose>
		<c:when test="${param.num1 eq 0 }">
			${param.num1 }은 0입니다.
		</c:when>
		<c:when test="${param.num1 gt 0 }">
			${param.num1 }은 양수입니다.
		</c:when>
		<c:when test="${param.num1 lt 0 }">
			${param.num1 }은 음수입니다.
		</c:when>
	</c:choose>
	
</body>
</html>