<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 700px;
	margin: auto;
	border: 0px solid gray;
	padding: 5px;
}
</style>
</head>
<body>
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
		if (month >= 13) {
			year++; // 년도를 늘리고
			month = 1; // 월을 1월로
		}
		// 월이 줄어들다보면 0월이 된다.
		if (month <= 0) {
			year--; // 년도를 줄이고
			month = 12; // 월을 12월로
		}
		// 년도의 유효성 검사
		if (year < 1) {
			year = cal.get(Calendar.YEAR);
		}
		// 음력 달력 API
		String address = "https://astro.kasi.re.kr/life/pageView/5?";
		address += String.format("search_year=%4d&search_month=%02d", year, month);
	%>
	<table>
		<tr>
			<td colspan="2" align="center"><a
				href="?yy=<%=(year - 1)%>&mm=<%=month%>">◀</a> <a
				href="?yy=<%=year%>&mm=<%=(month - 1)%>">◁</a> <a href="?yy=&mm="></a>
			</td>
			<td colspan="3" align="center" style="font-size: 22pt;"><%=String.format("%04d년 %02d월", year, month)%>
			</td>
			<td colspan="2" align="center"><a
				href="?yy=<%=year%>&mm=<%=(month + 1)%>">▷</a> <a
				href="?yy=<%=(year + 1)%>&mm=<%=month%>">▶</a></td>
		</tr>
	</table>
	<%
		// 음력 데이터를 가져오자
		out.println(address + "<br>");
		Document doc = Jsoup.connect(address).get();
		Elements trs = doc.select("table tbody tr");
		for(Element tr : trs) {
			out.println(tr.select("td").get(0).text() + "("); // 양력
			out.println(tr.select("td").get(1).text() + ") : "); // 음력
			out.println(tr.select("td").get(2).text() + "<br>"); // 간지 
		}
	%>
</body>
</html>