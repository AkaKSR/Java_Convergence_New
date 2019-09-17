<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코어 태그(변수 선언)</title>
</head>
<body>
	<%-- 변수를 선언한다. --%>
	<%-- int num1=100;과 같다. --%>
	<c:set var="num1" value="100" />
	<%-- int num2=200;과 같다. --%>
	<c:set var="num2" value="200" />
	<%-- JSTL에 EL 사용 --%>
	<c:set var="sum" value="${num1+num2 }" scope="session" />
	${num1 } + ${num2 } = ${sum } <br>
	<%-- 변수 제거 --%>
	<c:remove var="sum" scope="session" />
	${num1 } + ${num2 } = ${sum } <br>
</body>
</html>