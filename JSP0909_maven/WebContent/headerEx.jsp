<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	호스트 : <%= request.getHeader("host") %> <br />
	브라우저 : <%= request.getHeader("User-Agent") %> <br />
	
	호스트 : ${header.host } <br />
	호스트 : ${header["host"] } <br />
	<%-- 출력할 변수값에 공백이나 -표시가 잇을 경우에는 객체.값을 사용하면 않된다. --%>
	브라우저 : ${header.user-agent } <br /><%-- -가 계산되어 0이 출력된다. --%>
	브라우저 : ${header["User-Agent"] } <br />
	<hr />
	쿠키값 : <%=request.getCookies()[0].getValue() %> <br />
	쿠키값 : ${cookie["JSESSIONID"].value } <br />
	쿠키값 : ${cookie.JSESSIONID.value } <br />
</body>
</html>