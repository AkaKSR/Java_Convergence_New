<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<String> list = (List<String>) session.getAttribute("list");
	if(list==null) list = new ArrayList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(list.size()>0){
			for(String str : list){
				out.println(str + "<br>");
			}
		}else{
			out.println("저장된 메모가 없습니다.");
		}
	%>
	<br>
	<form action="pageResult.jsp" method="post">
		<input type="text" name="name" required="required" size="10" placeholder="이름">
		<input type="text" name="msg" required="required" size="80" placeholder="메모">
		<input type="submit" value="저장하기">
	</form>
</body>
</html>