<%@page import="java.net.URL"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리소스 접근</title>
</head>
<body>
	<%
		// 읽기
		InputStream is = application.getResourceAsStream("애국가(가사).txt");
		Scanner sc = new Scanner(is, "MS949");
		while (sc.hasNextLine()) {
			out.println(sc.nextLine() + "<br>");
		}

		sc.close();

		// 저장
		String path = application.getRealPath("aaa.txt");
		PrintWriter pw = new PrintWriter(path);
		pw.write("저장이 될까?\n");
		pw.write("저장이 될까?\n");
		pw.write("저장이 될까?\n");
		pw.flush();
		pw.close();
		out.println(application.getRealPath("/"));

		// URL객체를 이용하여 서버의 자원 읽기
		URL url = application.getResource("aaa.txt");
		Scanner sc2 = new Scanner(url.openStream());
		while (sc2.hasNextLine()) {
			out.println(sc2.nextLine());
		}
		sc2.close();
	%>
</body>
</html>