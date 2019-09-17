<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소 만들기</title>
</head>
<body>
	<%-- GET방식의 주소를 만들어 준다. 자동으로 Encoding이 된다. --%>
	<c:url var="url" value="JSTL_Ex02.jsp">
		<c:param name="num1" value="123"/>
		<c:param name="num2" value="21"/>
		<c:param name="name" value="한사람"/>
	</c:url>
	<a href="${url }">${url }</a>
</body>
</html>