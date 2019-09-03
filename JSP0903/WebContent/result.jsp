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
	// 채점하기
	int count=0;
	for(HanjaVO vo : testList){
		String a = request.getParameter("a" + vo.getN());
		out.println(vo.getN() + ". " + a + " : " + vo.getA() + "<br>");
		//if(a.equals(vo.getA())){ // 정답이 입력되지 않았을 경우 에러 발생
		if(vo.getA().equals(a)){ 
			count++;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=testList.size() %>문제 중 <%=count %>문제를 맞추었습니다.
</body>
</html>