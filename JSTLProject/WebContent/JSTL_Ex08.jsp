<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러처리</title>
</head>
<body>
	<%-- 에러가 발생할 소지가 있으면 c:catch 블럭으로 잡아준다. --%>
	<c:catch var="e">
		<%=10/0 %>
	</c:catch>
	<%-- 에러 판단은 --%>
	<c:if test="${not empty e }">
		에러가 발생하였습니다. ${e.message }
	</c:if>
</body>
</html>