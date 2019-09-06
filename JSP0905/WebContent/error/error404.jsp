<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 에러 발생시 보여줄 페이지 상단에는 다음의 디렉티브를 써야 한다. --%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="color:red;">
		에러가 발생하였습니다. <br>
		존재하지 않는 페이지를 요청하셨습니다. <br>
		URL주소를 다시 한번 확인해주시기 바랍니다. <br>
	</div>
</body>
</html>
<!-- IE는 자체적으로 에러 페이지 가지고 있다. -->
<!-- 에러 페이지 크기가 513바이트 이하일 경우에는 자체 에러 페이지르 보여준다. -->
<!-- 프로그래머를 귀찮게하는 나쁜 IE!!! -->
<!-- 프로그래머를 귀찮게하는 나쁜 IE!!! -->
<!-- 프로그래머를 귀찮게하는 나쁜 IE!!! -->
