<%@page import="kr.green.cookie.CookieUtil"%>
<%@page import="kr.green.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 일단은 세션에 저장된 회원정보를 읽어온다.
	// 회원정보가 있으면 "로그아웃"을 보여주고 없으면 "로그인"을 보여준다.
	MemberVO vo = (MemberVO)session.getAttribute("member");
	
	// 쿠키값을 읽어서 쿠키에 userid가 저장되어있으면 
	// 아이디 박스에 아이디가 표시되고 아이디 자동저장은 체크되어있어야 한다.
	CookieUtil cookieUtil = new CookieUtil(request);
	String userid = "";
	if(cookieUtil.hasCookie("userid")) userid = cookieUtil.getCookie("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#loginBtn, #logoutBtn { width: 80px; height: 50px;}
	input[type="text"], input[type="password"]{
		width:130px;
	}
	input[type="text"]:focus, input[type="password"]:focus{
		background-color: pink;
	}
</style>
</head>
<body>
	<% if(vo==null){ %>
	<form action="loginOk.jsp" method="post">
	<table style="border: 1px solid gray;padding:5px;">
		<tr>
			<td><input type="text" name="userid" required="required" placeholder="아이디입력" 
			           tabindex="1" <%=(!userid.equals("")? "value='"+ userid +"'" : "") %>> </td>
			<td rowspan="2"><input type="submit" value="로그인" id="loginBtn" tabindex="3"></td> 
		</tr>
		<tr>
			<td><input type="password" name="password" required="required" placeholder="비밀번호입력" tabindex="2"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<label>
				<input type="checkbox" name="saveID" value="1" 
				       <%=(!userid.equals("")? "checked='checked'" : "") %>> 아이디 자동저장
				</label>
			</td>
		</tr>
	</table>
	</form>
	<% }else{ %>
	<table style="border: 1px solid gray;padding:5px;">
		<tr>
			<td> <%=vo.getNickName() %>님 반가워요! </td>
			<td rowspan="2">
				<input type="button" value="로그아웃" id="logoutBtn" onclick="location.href='logout.jsp'">
			</td> 
		</tr>
		<tr>
			<td>포인트 : <%=vo.getPoint() %>점 </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				사용자 아이디 : <%=vo.getUserid() %>
			</td>
		</tr>
	</table>	
	<% } %>
</body>
</html>