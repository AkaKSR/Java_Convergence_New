<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함수 사용</title>
</head>
<body>
	<c:set var="email" value="admin@korea.com"/>
	${fn:substring(email,6,11) } <br>
	${fn:substringAfter(email,"@") } <br>
	${fn:substringBefore(email,"@") } <br>
	${fn:replace(email,"korea","naver") } <br>
	<c:set var="email2" value='${fn:replace(email,"korea","naver") }'/>
	${email2 }
	<c:set var="tag" value="<h1>하하하하하하</h1>"/>
	${tag }<br>
	${fn:escapeXml(tag) }<br>
</body>
</html>