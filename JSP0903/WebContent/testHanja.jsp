<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="kr.green.hanja.vo.HanjaVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 몇급 몇해 시험을 보는지를 알아내야 한다.
	request.setCharacterEncoding("UTF-8");
	
	// POST전송이 아닐경우 몇급 몇해 시험 선택화면으로 보낸다.
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("readHanja.jsp");
		return;
	}

	// 넘어온 데이터 받기
	String select = request.getParameter("select");
	
	// 시험 문제에서 해당 회차만 뽑아내자!!!
	// 모두 읽기
	Gson gson = new Gson();
	InputStreamReader isr = new InputStreamReader(application.getResourceAsStream("json/hanjatest.json"));
	List<HanjaVO> hanjaList = 
			      gson.fromJson(isr, new TypeToken<List<HanjaVO>>(){}.getType()); // 리스트로 읽기
	// 해당 회차만 뽑기
	List<HanjaVO> testList = new ArrayList<>();
	for(HanjaVO vo : hanjaList){
		if(select.equals(vo.getD() + " " + vo.getS())){
			testList.add(vo);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=select %> 시험보기</title>
</head>
<body>
	<form action="result.jsp" method="post">
	<input type="hidden" name="select" value="<%=select%>">
	<% for(HanjaVO v : testList){ %>
			<%=v.getN() %>번 문제 : <%=v.getQ() %><br> 
			<%
				if(v.getE1()==null || v.getE1().trim().length()==0){
					// 단답형
			%>
				<input type="text" name="a<%=v.getN() %>">
			<%
				}else{
					// 선택형
			%>
				<label><input type="radio" name="a<%=v.getN() %>" value="1"> <%=v.getE1() %></label>
				<label><input type="radio" name="a<%=v.getN() %>" value="2"> <%=v.getE2() %></label>
				<label><input type="radio" name="a<%=v.getN() %>" value="3"> <%=v.getE3() %></label>
				<label><input type="radio" name="a<%=v.getN() %>" value="4"> <%=v.getE4() %></label>
			<%
				}
			%>
			<hr>	
	<% } %>
		<input type="submit" value="채점하기">	
	</form>
</body>
</html>








