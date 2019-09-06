<%@page import="java.io.PrintWriter"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String t = request.getParameter("date");
	if (t == null || t.trim().equals("")) { // 데이터가 넘어오지 않았다면
		response.sendRedirect("CalEx02.jsp");
		return;
	}
	String filename = request.getParameter("file");
	if (filename == null || filename.trim().equals("")) { // 데이터가 넘어오지 않았다면
		response.sendRedirect("CalEx02.jsp");
		return;
	}
	System.out.print(filename);
	System.out.print(t);

	try {
		int date = Integer.parseInt(t);

		// 파일의 내용을 읽자
		Gson gson = new Gson();
		InputStreamReader isr = new InputStreamReader(application.getResourceAsStream(filename));
		int ar[] = gson.fromJson(isr, int[].class);

		// 원래는 이렇게 해야 한다.
		// ar[date-1] = 1; // 넘어온 날짜의 상태를 1로 바꾼다. ===> 출석

		// 1번 밖에 테스트가 안되므로 이미지를 반전시켜보자
		if (ar[date - 1] == 1)
			ar[date - 1] = 0;
		else
			ar[date - 1] = 1;

		// 다시 저장한다.
		String path = application.getRealPath(filename); // 서버의 실제 경로 얻기
		PrintWriter pw = new PrintWriter(path);
		gson.toJson(ar, pw); // json파일로 저장
		pw.flush();
		pw.close();

	} catch (Exception e) {
		;
	}

	// 다시 출석부 화면으로 
	response.sendRedirect("CalEx02.jsp?yy=" + filename.substring(0, 4) + "&mm=" + filename.substring(4, 6));
%>
