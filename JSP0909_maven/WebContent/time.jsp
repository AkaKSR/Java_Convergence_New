<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="today" class="java.util.Date" scope="page">
		${today.hours }시 ${today.minutes }분 ${today.seconds }초
	</jsp:useBean>
</body>
</html>