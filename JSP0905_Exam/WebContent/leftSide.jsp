<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이드 메뉴</title>
<style type="text/css">
div {
	text-align: left;
	padding: 5px;
	margin-bottom: 10px;
}

td {
	width: 180px;
	height: 300px;
}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>

	<div>

		<table>
			<tr>
				<td><a href="page1.jsp">메뉴 01</a></td>
			</tr>
			<tr>
				<td><a href="page2.jsp">메뉴 02</a></td>
			</tr>
			<tr>
				<td><a href="page3.jsp">메뉴 03</a></td>
			</tr>
			<tr>
				<td><a href="page4.jsp">메뉴 04</a></td>
			</tr>
			<tr>
				<td><a href="page5.jsp">메뉴 05</a></td>
			</tr>
		</table>
	</div>
</body>
</html>