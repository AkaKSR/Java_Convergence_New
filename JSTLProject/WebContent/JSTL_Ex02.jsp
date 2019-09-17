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
	<c:if test="${empty param.num1 or empty param.num2}">
		${pageContext.request.requestURI }?num1=10&num2=20 으로 실행하세요.<br>
	</c:if>
	<c:if test="${not empty param.num1 or not empty param.num2}">
	${param.num1 } + ${param.num2 } = ${param.num1 + param.num2 } <br>
	${param.num1 } - ${param.num2 } = ${param.num1 - param.num2 } <br>
	${param.num1 } * ${param.num2 } = ${param.num1 * param.num2 } <br>
	${param.num1 } / ${param.num2 } = ${param.num1 / param.num2 } <br>
	${param.num1 } % ${param.num2 } = ${param.num1 % param.num2 } <br>
	</c:if>
</body>
</html>