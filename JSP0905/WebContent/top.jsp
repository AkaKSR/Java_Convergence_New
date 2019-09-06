<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상단</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = null;
		try {
		name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
		} catch (Exception e) {
			; // 에러가 나도 아무짓도 하지 않는다.
		}
	%>
	<div><%=name%>
		회사
	</div>
	<div>
		<a href="page1.jsp">메뉴1</a> <a href="page2.jsp">메뉴2</a> <a
			href="page3.jsp">메뉴3</a> <a href="page4.jsp">메뉴4</a>
	</div>
</body>
</html>