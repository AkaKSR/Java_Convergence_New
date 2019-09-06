<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수의 읽기</title>
</head>
<body>
	저장된 영역의 변수들<br>
	<%-- 다른 페이지에서 선언한 변수는 사용 불가 --%>
	page : <%//=var %><br>
	pageContext : <%=pageContext.getAttribute("var") %><br>
	request : <%=request.getAttribute("var") %><br>
	session : <%=session.getAttribute("var") %><br>
	application : <%=application.getAttribute("var") %><br>
</body>
</html>