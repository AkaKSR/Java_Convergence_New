<%@page import="java.util.ArrayList"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.green.jdbc.JdbcUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 조회하기</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemoVO> list = null;
		try {
			conn = JdbcUtil.getDbcpConnection();
			conn.setAutoCommit(false);
			// =================================================== //
			String sql = "select * from memo order by idx desc";
			String insertSql = "insert into memo (name,password,memo,regdate,ip) values ('한사람','1234','블라블라',now(),'192.168.0.1')";
			stmt = conn.createStatement();
			// rs = stmt.executeQuery(insertSql);
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				list = new ArrayList<MemoVO>();
				do {
					MemoVO vo = new MemoVO();
					// DB에서 데이터를 읽어서 VO를 채워준다.
					vo.setIdx(rs.getInt("idx"));
					vo.setName(rs.getString("name"));
					vo.setPassword(rs.getString("password"));
					vo.setMemo(rs.getString("memo"));
					vo.setRegDate(rs.getTimestamp("regdate"));
					vo.setIp(rs.getString("ip"));
					list.add(vo);
				} while (rs.next());
			}
			// =================================================== //
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		request.setAttribute("list", list);
		pageContext.forward("selectView.jsp");
	%>
</body>
</html>