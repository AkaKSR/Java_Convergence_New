<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.util.List"%>
<%@page import="kr.green.hanja.vo.HanjaVO"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Gson gson = new Gson();
		InputStreamReader isr = new InputStreamReader(application.getResourceAsStream("json/hanjatest.json"));
		// HanjaVO[] hanjaVOs = gson.fromJson(isr, HanjaVO[].class); // 배열로 읽기
		List<HanjaVO> hanjaList = 
				      gson.fromJson(isr, new TypeToken<List<HanjaVO>>(){}.getType()); // 리스트로 읽기
		
		out.println(hanjaList.size() + "개 읽음<br>");
	
		// 급수와 시험회차만 뽑기		      
		Set<String> set = new HashSet<String>(); // 중복 제거
		for(HanjaVO vo : hanjaList){
			set.add(vo.getD() + " " + vo.getS());
		}
		out.println(set.size() + "개<br>");
	%>
	<form action="testHanja.jsp" method="post">
		선택 : 
		<select name="select">
		<%		
			for(String t : set){
				out.println("<option value='"+ t +"'>" + t + "</option>");
			}
		%>
		</select>
		<input type="submit" value="시험보기">
	</form>
</body>
</html>







