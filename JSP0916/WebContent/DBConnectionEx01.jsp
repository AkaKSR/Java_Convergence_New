<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MariaDB 연동하기</title>
</head>
<body>
	<%
		// 1. 변수 세팅
		String driverClass = "org.mariadb.jdbc.Driver";
		// String urlAddress = "jdbc:mariadb://서버IP:포트번호/DB이름";
		String urlAddress = "jdbc:mariadb://127.0.0.1:3306/jspdb";
		String user = "jspuser";
		String password = "123456";

		// 2. 드라이버 로드
		Class.forName(driverClass);

		Connection conn = null; // 연결 객체 선언
		Statement stmt = null; // 명령 객체 선언
		ResultSet rs = null; // 결과 객체 선언
		try {
			// 3. 연결
			conn = DriverManager.getConnection(urlAddress, user, password); // 연결 객체 생성
			out.println("연결 성공: " + conn + "<br>");

			// 4. 사용
			String sql = "select * from person";
			stmt = conn.createStatement(); // 명령 객체 생성
			rs = stmt.executeQuery(sql); // 결과 객체 생성

			if (rs.next()) { // 첫번째 ResultSet을 받아온다.
				do {
					out.println(rs.getInt("idx") + ". ");
					out.println(rs.getString("name") + "(");
					out.println(rs.getInt("age") + "세)<br>");
				} while (rs.next()); // 그 다음 ResultSet을 받아온다. 
			}

			// 5. 닫기
			// 닫을때는 열은 순서의 반대로 닫아준다.
		} catch (SQLException e) {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e3) {
					;
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e2) {
					;
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e1) {
					;
				}
		}
	%>
</body>
</html>