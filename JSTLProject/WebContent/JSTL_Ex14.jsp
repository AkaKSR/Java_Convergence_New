<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자를 원하는 모양으로</title>
</head>
<body>
	<c:set var="num" value="123456789.45678"/>
	${num }<br>
	<fmt:formatNumber value="${num }"/> <br>
	<fmt:formatNumber value="${num }" groupingUsed="false"/> <br>
	<fmt:formatNumber value="0.3456" type="percent"/> <br>
	<fmt:formatNumber value="12345.567" type="currency"/> <br>
	<fmt:formatNumber value="12345.567" type="currency" currencySymbol="$"/> <br>
	<hr>
	<fmt:formatNumber value="123.456" pattern="#,###.00"/> <br>
	<fmt:formatNumber value="123.4" pattern="#,###.00"/> <br>
	<fmt:formatNumber value="123.456" pattern="#,###.##"/> <br>
	<fmt:formatNumber value="123.4" pattern="#,###.##"/> <br>
</body>
</html>