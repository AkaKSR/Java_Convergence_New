<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="vo.ChunjaVO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" 
    trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%
	Gson gson = new Gson();
	InputStreamReader isr = new InputStreamReader(application.getResourceAsStream("chunja.json"));
	List<ChunjaVO> list = gson.fromJson(isr, new TypeToken<List<ChunjaVO>>(){}.getType());
	
	int no = 0;
	try{
		System.out.println(request.getParameter("no"));
		no = Integer.parseInt(request.getParameter("no"));
	}catch(Exception e){
		;
	}
	
	if(no<=0 || no>1000){
		out.println("{\"h\":\"\",\"m\":\"\"}");
	}else{
		out.println(gson.toJson(list.get(no-1)));
	}
%>