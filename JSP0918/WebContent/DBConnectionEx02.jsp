<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.green.jdbc.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DBConnection</title>
</head>
<body>
	<%
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	try {
		conn = JdbcUtil.getConnection(); // 연결하고
		out.println("연결 성공 : " + conn + "<br>"); // 연결이 되었는지 확인
		// 트랜젝션 시작
		// JSP는 기본값이 자동 커밋이다.
		conn.setAutoCommit(false); // 자동 커밋 해제
		// =======================================================
		stmt = conn.createStatement(); // 명령얻고
		rs = stmt.executeQuery("select now()"); // 명령 실행
		rs.next();
		out.println(rs.getString(1) + "<br>"); // 결과 얻기
		// =======================================================
		// 트랜젝션 적용
		conn.commit();
	} catch(SQLException e) {
		// 에러 발생시 모든 명령 취소
		JdbcUtil.rollback(conn);
		e.printStackTrace();
	} finally {
		// 닫기
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
	}
%>
</body>
</html>