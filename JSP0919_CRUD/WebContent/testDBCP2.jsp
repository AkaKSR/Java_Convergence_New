<%@page import="kr.co.ipdisk.akaksr.jdbc.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
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
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			// 3. 사용
			out.println("연결 성공 : " + conn);
			// ------------------------------------------------------------------ //
			
			// ------------------------------------------------------------------ //
			conn.commit(); // 커밋
		} catch (SQLException e1) {
			JdbcUtil.rollback(conn);
			e1.printStackTrace();
		} finally {
			// 4. 닫기
			JdbcUtil.closeAll(conn, stmt, rs);
		}
	%>
</body>
</html>