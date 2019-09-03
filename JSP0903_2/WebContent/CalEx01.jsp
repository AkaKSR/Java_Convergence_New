<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR); // 현재 년도
	int month = cal.get(Calendar.MONTH) + 1; // 현재 월
	int date = cal.get(Calendar.DAY_OF_MONTH); // 현재 일
	// 달력을 그리기 위해서는 1일의 요일이 필요하다.
	cal.set(year, month - 1, 1); // 달력을 1일로 변경
	int week = cal.get(Calendar.DAY_OF_WEEK);
	// 그달의 마지막 날짜가 필요하다.
	int lastday = cal.getActualMaximum(Calendar.DATE);
	/*
	0) ​프로그램이 시작되면 년월.json파일을 찾아서 없으면 자동으로 생성해주고 있으면 읽는다.
	1) 정수배열을 날짜만큼 만들자
	2) 값이 0이면 결석 1이면 출석으로 처리하자
	3) 이 데이터를 json으로 저장하자
	*/
	String filename = String.format("%04d%02d.json", year, month); // 파일이름 만들기
	String path = application.getRealPath(filename); // 서버의 실제 경로 얻기
	File file = new File(path); // 파일 객체 생성
	Gson gson = new Gson();

	if (!file.exists()) { // 파일이 존재하지 않으면
		// 만들어 주고
		int data[] = new int[lastday]; // 월의 크기만큼 배열을 만들어서
		PrintWriter pw = new PrintWriter(path);
		gson.toJson(data, pw);
		pw.flush();
		pw.close();
	}
	// 파일의 내용을 읽자
	InputStreamReader isr = new InputStreamReader(application.getResourceAsStream(filename));
	int ar[] = gson.fromJson(isr, int[].class);
	// ar[0] = 1; // 출석 도장이 보이는지 확인하기위해 임시로 넣기

	// ar배열에 1달치의 출석 정보가 들어있게 된다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년 달력 만들기</title>
<style type="text/css">
table {
	width: 550px;
	margin: auto;
	border: 0px solid gray;
	padding: 5px;
}

th {
	background-color: silver;
	padding: 5px;
	width: 100px;
}

.dateStyle {
	border: 1px solid gray;
	padding: 5px;
	padding: 5px;
	font-size: 22pt;
	text-align: right;
	width: 70px;
	height: 70px;
	vertical-align: top;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="7" align="center" style="font-size: 22pt;"><%=String.format("%04d년 %02d월", year, month)%>
			</td>
		</tr>
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		<tr>
			<%
				// 1일의 요일 자리를 맞추기 위해 앞에 빈칸을 출력한다.
				for (int i = 1; i < week; i++)
					out.println("<td class='dateStyle'>&nbsp;</td>");
				// 1일부터 마지막 날짜까지 출력
				for (int i = 1; i <= lastday; i++) {
					if (i <= date) { // 오늘 이전 까지
						if (i == date && ar[i-1] == 0) { // 오늘이면서 출석이 아니면 "출첵" 이미지 표시
							out.println("<td class='dateStyle' onclick='location.href=\"update.jsp?date="+date+"\"' style='background-image: url(\"images/c.jpg\");'>" + i
									+ "</td>");
						} else if (ar[i - 1] == 0) { // 결석이면
							out.println("<td class='dateStyle' onclick='location.href=\"update.jsp?date="+i+"\"' style='background-image: url(\"images/b.jpg\");'>" + i
									+ "</td>");
						} else if (ar[i - 1] == 1) { // 출석이면
							out.println("<td class='dateStyle' onclick='location.href=\"update.jsp?date="+i+"\"' style='background-image: url(\"images/a.jpg\");'>" + i
									+ "</td>");
						}
					} else { // 오늘 다음 부터는 배경 이미지를 출력하지 않는다.
							out.println("<td class='dateStyle'>" + i
									+ "</td>");
					}

					cal.set(year, month - 1, i); // 달력을 i일로 변경
					week = cal.get(Calendar.DAY_OF_WEEK);
					// 출력한 날짜가 토요일이면 줄바꿈
					if (week == 7) {
						out.println("</tr>");
						// 출력할 날짜가 남았다면 새로운 줄을 시작해야 한다.
						if (i < lastday)
							out.println("<tr>");
					}
				}
				// 표의 뒷 부분을 마무리 하자!!
				// 마지막 날짜의 요일이 토요일이 아니면 빈칸을 출력해 준다.
				if (week < 7) {
					for (; week < 7; week++)
						out.println("<td class='dateStyle'>&nbsp;</td>");
					out.println("</tr>");
				}
			%>
		
	</table>
</body>
</html>










