<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL에서 pageContext 객체 사용</title>
</head>
<body>
	접속자 IP : <%=request.getRemoteAddr() %> <br />
	접속자 IP : ${pageContext.request.remoteAddr } <br />
	경로 : ${pageContext.request.servletPath } <br />
	경로 : ${pageContext.request.contextPath } <br />
	경로 : ${pageContext.request.requestURI } <br />
	경로 : ${pageContext.request.requestURL } <br />
	
</body>
</html>