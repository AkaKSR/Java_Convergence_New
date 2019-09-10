<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	user : <%=application.getInitParameter("user") %> <br />
	password : <%=application.getInitParameter("password") %> <br />
	<hr />
	user : ${initParam.user } <br />
	password : ${initParam.password } <br />
</body>
</html>