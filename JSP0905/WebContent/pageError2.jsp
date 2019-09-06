<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%-- 이 페이지에서 에러가 발생하면 에러메세지 대신에 error/error.jsp 페이지를 보여줘라 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: <%=request.getParameter("name").toUpperCase()%>
	
</body>
</html>