<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// chunja.txt 파일 읽어오기
	InputStream is = application.getResourceAsStream("chunja.txt");
	Scanner sc = new Scanner(is, "UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 150px;
	margin: 5px;
	border: 1px solid gray;
	border-radius:20px;
	float: left;
}

</style>
</head>
<body>
	<%
		while(sc.hasNextLine()) {
			String[] hanja = sc.nextLine().split("\\|");
	%>
	<table>
		<tr align="center">
			<td style="font-size: 30pt; font-weight: bold; padding: 5px;"><%=hanja[1] %></td>
		</tr>
		<tr align="center">
			<td style="border-top: 1px solid gray; font-weight: bold; padding: 3px; font-size: 8pt;"><%=hanja[3] %></td>
		</tr>
	</table>
	<%} %>
</body>
</html>