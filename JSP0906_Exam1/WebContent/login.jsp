<%@page import="kr.green.test.util.CookieUtil"%>
<%@page import="kr.green.test.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO) session.getAttribute("member");

	CookieUtil cookieUtil = new CookieUtil(request);
	String userid = "";
	if(cookieUtil.hasCookie("userid")) userid = cookieUtil.getCookie("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	#loginBtn {
		width: 100px;
		height: 50px;
	}
	table {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<% if(vo==null) { %>
	<form action="loginOk.jsp" method="post">
		<table>
			<tr>
				<td colspan="2">
					<input type="text" name="userid" id="userid" placeholder="아이디 입력" required="required" tabindex="1">
				</td>
				<td rowspan="2">
					<input type="submit" name="loginBtn" id="loginBtn" value="로그인" tabindex="3">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="password" id="password" placeholder="비밀번호 입력" required="required" tabindex="2">
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<label>
						<input type="checkbox" name="saveID" value="1" <%=(!userid.equals("")? "checked='checked'" : "") %>> 아이디 자동저장
					</label>
				</td>
			</tr>
		</table>
	</form>
	<% } else { %>
		<table>
			<tr>
				<td>
				<%=vo.getNickName() %>님 반가워요!
				</td>
				<td rowspan="2">
					<input type="button" name="logoutBtn" id="logoutBtn" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
			</tr>
			<tr>
				<td>
				포인트 : <%=vo.getPoint() %>P
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					사용자 아이디: <%=vo.getUserid() %>
				</td>
			</tr>
		</table>
	<% } %>
</body>
</html>