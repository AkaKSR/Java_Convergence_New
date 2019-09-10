<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수의 영역</title>
</head>
<body>
	<%
		// EL로 출력하려면 4개의 영역중 한군데에 저장되어 있어야 한다.
		int var = 1;
		pageContext.setAttribute("var", 2);
		request.setAttribute("var", 3);
		session.setAttribute("var", 4);
		application.setAttribute("var", 5);
		String name = request.getParameter("name");
	%>
	이름 : <%=name %> <br>
	이름 : ${name } <br>
	값: ${var } <br> <%-- 영역을 저장하지 않으면 제일 작은 영역의 변수값이 출력된다. --%>
	pageScope 값 : ${pageScope.var } <br>
	requestScope 값 : ${requestScope.var } <br>
	sessionScope 값 : ${sessionScope.var } <br>
	applicationScope 값 : ${applicationScope.var } <br>
</body>
</html>