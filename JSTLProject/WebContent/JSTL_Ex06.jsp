<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 구구단</title>
</head>
<body>
	<table border="1">
	<tr>
	<c:forEach var="i" begin="2" end="9">
		<th width="100">${i }단</th>
	</c:forEach>
	</tr>
	<c:forEach var="i" begin="1" end="9">
		<tr align="center">
		<c:forEach var="j" begin="2" end="9">
			<td>
			${j }*${i }=${i*j }
			</td>
		</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>