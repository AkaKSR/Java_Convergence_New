<%@page import="kr.co.ipdisk.akaksr.jdbc.JdbcUtil"%>
<%@page import="kr.co.ipdisk.akaksr.memo.vo.MemoVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int idx = -1;
	try {
		idx = Integer.parseInt(request.getParameter("idx"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (idx < 0) {
		response.sendRedirect("list.jsp");
		return;
	}

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	MemoVO vo = null;
	try {
		conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		// ===================================================== //
		String sql = "select * from memo where idx=" + idx;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo = new MemoVO();
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setPassword(rs.getString("password"));
			vo.setMemo(rs.getString("memo"));
			vo.setRegDate(rs.getTimestamp("regdate"));
			vo.setIp(rs.getString("ip"));
		}
		// ===================================================== //
		conn.commit();
	} catch (Exception e) {
		JdbcUtil.rollback(conn);
		e.printStackTrace();
	} finally {
		JdbcUtil.closeAll(conn, stmt, rs);
	}
	
	// vo가 null이면 글이 없다.
	if (vo==null) {
		response.sendRedirect("list.jsp");
		return;
	}
	request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#form").submit(function() {
			var value = $("#password").val();
			if (value.trim().length == 0) {
				alert('암호를 정확하게 입력해주시기 바랍니다.');
				$("#password").val("");
				$("#password").focus();
				return false;
			}
			var value = $("#memo").val();
			if (value.trim().length == 0) {
				alert('메모를 정확하게 입력해주시기 바랍니다.');
				$("#memo").val("");
				$("#memo").focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form action="updateOk.jsp" method="post" id="form">
		<div class="form-group">
		<input type="hidden" name="idx" value="${vo.idx }" />
			<input type="text" class="form-control" id="name" name="name"
				placeholder="이름 입력" readonly="readonly" value="${vo.name }">
			<input type="password" class="form-control" id="password" name="password"
				placeholder="암호 입력" required="required">
			<input type="text" class="form-control" id="memo" name="memo"
				placeholder="내용 입력" required="required" value="${vo.memo }">
		</div>
		<button type="submit" class="btn btn-primary btn-sm">수정하기</button>
		<button class="btn btn-primary btn-sm" onclick="location.href='list.jsp'">취소하기</button>
	</form>
</body>
</html>