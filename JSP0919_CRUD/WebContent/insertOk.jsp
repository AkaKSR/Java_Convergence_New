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
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			// ===================================================== //
			String sql = "insert into memo(name,password,memo,regdate,ip) values(?,?,?,now(),?)";
			pstmt = conn.prepareStatement(sql); // 미완성 명령이 생성
			// ? 자리에 값을 채워준다.
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMemo());
			pstmt.setString(4, vo.getIp());
			
			// 명령 실행
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 저장완료.");
			// ===================================================== //
			conn.commit();
		} catch(Exception e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(conn, pstmt, null);
		}
		
		response.sendRedirect("list.jsp");
 	%>
</body>
</html>