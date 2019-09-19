<%@page import="kr.co.ipdisk.akaksr.memo.vo.MemoVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.co.ipdisk.akaksr.jdbc.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- vo객체 생성 --%>
	<jsp:useBean id="vo" class="kr.co.ipdisk.akaksr.memo.vo.MemoVO"/>
	<%-- 모든 setter 호출 --%>
	<jsp:setProperty property="*" name="vo"/>
	<%-- ip는 수동으로 넣어준다. --%>
	<jsp:setProperty property="ip" name="vo" value="${pageContext.request.remoteAddr }"/>
	${vo }
	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			// 데이터 베이스에서 원본을 읽어와서
			String sql = "select * from memo where idx=" + vo.getIdx();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			MemoVO dbVO = null;
			if (rs.next()) {
				dbVO = new MemoVO();
				dbVO.setIdx(rs.getInt("idx"));
				dbVO.setName(rs.getString("name"));
				dbVO.setPassword(rs.getString("password"));
				dbVO.setMemo(rs.getString("memo"));
				dbVO.setRegDate(rs.getTimestamp("regdate"));
				dbVO.setIp(rs.getString("ip"));
			}
			// 넘어온 비밀번호가 일치 한다면 그때만 삭제한다.
			
			// ===================================================== //
			if (dbVO != null && dbVO.getPassword().equals(vo.getPassword())) {
				sql = "delete from memo where idx=?";
				pstmt = conn.prepareStatement(sql); // 미완성 명령이 생성
				// ? 자리에 값을 채워준다.
				pstmt.setInt(1, vo.getIdx());
			
				// 명령 실행
				int count = pstmt.executeUpdate();
				System.out.println(count + "개 삭제완료.");
			}
			// ===================================================== //
			conn.commit();
		} catch(Exception e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		
		response.sendRedirect("list.jsp");
 	%>
</body>
</html>