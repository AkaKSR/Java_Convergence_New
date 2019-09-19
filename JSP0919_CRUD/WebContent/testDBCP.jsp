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
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/SqlDB");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			// 3. 사용
			out.println("연결 성공 : " + conn);
			//------------------------------------------------------------------
			
			//------------------------------------------------------------------
			conn.commit(); // 커밋
		} catch (SQLException e1) {
			out.println("실패 : " + e1.getMessage());
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException e2) {
				out.println("실패 : " + e2.getMessage());
			}
		} finally {
			// 4. 닫기
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				out.println("실패 : " + e.getMessage());
			}

			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				out.println("실패 : " + e.getMessage());
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				out.println("실패 : " + e.getMessage());
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				out.println("닫기 실패 : " + e.getMessage());
			}
		}
	%>
</body>
</html>