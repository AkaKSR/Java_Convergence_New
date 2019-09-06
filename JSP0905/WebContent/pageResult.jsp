<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String msg = request.getParameter("msg");
	String ip = request.getRemoteAddr();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
	String message = name + "씨가 " + ip + "에서 ";
	message += sdf.format(new Date()) + "에 남긴메모<br>";
	message += msg + "<br><hr>";
	
	List<String> list = (List<String>) session.getAttribute("list");
	if(list==null) list = new ArrayList();
	list.add(message);
	session.setAttribute("list", list);
	//pageContext.setAttribute("list", list);
	response.sendRedirect("pageAreaEx.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=message %>
</body>
</html>