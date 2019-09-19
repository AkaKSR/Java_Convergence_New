<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.ipdisk.akaksr.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.ipdisk.akaksr.jdbc.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
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
	ResultSet rs = null;
	List<MemoVO> list = null;
	try {
		conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		// ===================================================== //
		String sql = "select * from memo order by idx desc";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			list = new ArrayList<>();
			do {
				MemoVO vo = new MemoVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setMemo(rs.getString("memo"));
				vo.setRegDate(rs.getTimestamp("regdate"));
				vo.setIp(rs.getString("ip"));
				list.add(vo);
			} while(rs.next());
		}
		// ===================================================== //
		conn.commit();
	} catch(Exception e) {
		JdbcUtil.rollback(conn);
		e.printStackTrace();
	} finally {
		JdbcUtil.closeAll(conn, stmt, rs);
	}
	
	// 표시해줄 jsp페이지로 이동
	request.setAttribute("list", list);
	pageContext.forward("listView.jsp");
	%>
</body>
</html>