<%@page import="kr.green.jdbc.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBCP에서 컨넥션 얻기</title>
</head>
<body>
	<%
		Connection conn = JdbcUtil.getDbcpConnection();
		
		out.println("연결 성공 : " + conn + "<br>");
		
		JdbcUtil.close(conn);
	%>
</body>
</html>