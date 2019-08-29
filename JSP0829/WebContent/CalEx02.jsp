<%@page import="kr.green.cal.DateUtil"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Calendar cal = Calendar.getInstance();
	// 년도와 월을 받아온다.
	int year = cal.get(Calendar.YEAR); // 현재 년도
	int month = cal.get(Calendar.MONTH) + 1; //현재 월
	try { // 숫자가 아닌값이 넘어왔을때는 catch로 넘어가 현재 년도를 가진다.
		year = Integer.parseInt(request.getParameter("yy"));
	} catch (Exception e) {
		;
	}
	try { // 숫자가 아닌값이 넘어왔을때는 catch로 넘어가 현재 월을 가진다.
		month = Integer.parseInt(request.getParameter("mm"));
	} catch (Exception e) {
		;
	}
	// 월이 늘어나다보면 13월이 된다.
	if(month >= 13) {
		year++; // 년도를 늘리고
		month = 1; // 월을 1월로
	}
	// 월이 줄어들다보면 0월이 된다.
	if(month <= 0) {
		year--; // 년도를 줄이고
		month = 12; // 월을 12월로
	}
	// 년도의 유효성 검사
	if(year < 1) {
		year = cal.get(Calendar.YEAR);
	}
	// 달력을 그리기 위해서는 1일의 요일이 필요하다.
	cal.set(year, month-1, 1); // 달력을 1일로 변경
	int week = DateUtil.getWeekday(year, month, 1); // 그 달의 첫번째 요일을 저장.
	// 그 달의 마지막 날짜가 필요하다.
	int lastday = DateUtil.getLastday(year, month); // 그 달의 마지막 요일을 저장.
	
	System.out.println(week + ", " + lastday);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년 달력 만들기</title>
<style type="text/css">
	table {
		width: 700px; margin: auto; border: 0px solid gray; padding: 5px;
	}
	th {
		background-color: silver; padding: 5px; width: 100px;
	}
	.dateStyle {
		border: 1px solid gray; padding: 5px; font-size: 12pt; text-align: right;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" align="center">
				<a href="?yy=<%=(year-1) %>&mm=<%=month%>">◀</a>
				<a href="?yy=<%=year %>&mm=<%=(month-1)%>">◁</a>
				<a href="?yy=&mm="></a>
			</td>
			<td colspan="3"  align="center" style="font-size: 22pt;">
				<%=String.format("%04d년 %02d월",year, month) %>
			</td>
			<td colspan="2" align="center">
				<a href="?yy=<%=year %>&mm=<%=(month+1)%>">▷</a>
				<a href="?yy=<%=(year+1) %>&mm=<%=month%>">▶</a>
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
			//1일의 요일 자리를 맞추기 위해 앞에 빈칸을 출력한다.
				for(int i = 1; i < week; i++) out.println("<td class='dateStyle'>&nbsp;</td>");
			// 1일부터 마지막 날짜까지 출력
				for(int i = 1; i <= lastday; i++) {
					out.println("<td class='dateStyle'>" + i + "</td>");
					week = DateUtil.getWeekday(year, month, i);
					// 출력한 날짜가 토요일이면 줄바꿈
					if(week==7) {
						out.println("</tr>");
						// 출력할 날짜가 남았다면 새로운 줄을 시작해야 한다.
						if(i < lastday) out.println("<tr>");
					}
					
				}
			// 표의 뒷 부분을 마무리 하자.
			// 마지막 날짜의 요일이 토요일이 아니면 빈칸을 출력해 준다.
			if(week<7){
					for(;week<7;week++) out.println("<td class='dateStyle'>&nbsp;</td>");	
					out.println("</tr>");
				}
			%>
		</tr>
	</table>
</body>
</html>