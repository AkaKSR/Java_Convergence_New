<%@page import="kr.green.cal.LunarUtil"%>
<%@page import="kr.green.cal.LunarVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<LunarVO> list = LunarUtil.getList(2018, 8);
		for(LunarVO vo : list) {
			out.println(vo.getSolarDate() + " : " + vo.getLunarDate() + " : " + vo.getGanjiDate() + "<br>");
		}
	%>
</body>
</html>