<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 달력</title>
<style type="text/css">
table {
	width: 700px;
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
	font-size: 12pt;
	text-align: right;
}
</style>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date" scope="page" />
	<%-- 현재 년월 구하기 --%>
	<c:set var="year" value="${date.year + 1900 }" />
	<c:set var="month" value="${date.month + 1 }" />
	<%-- 년도가 넘어왓으면 년도 받기 --%>
	<c:if test="${not empty param.yy}">
		<c:set var="year" value="${param.yy }" />
	</c:if>
	<%-- 월이 넘어왔으면 월 받기 --%>
	<c:if test="${not empty param.mm}">
		<c:set var="month" value="${param.mm }" />
	</c:if>
	<%-- 월이 13이상이면 월을 1로 년도는 증가 --%>
	<c:if test="${month ge 13 }">
		<c:set var="year" value="${year + 1 }" />
		<c:set var="month" value="1" />
	</c:if>
	<%-- 월이 0이하이면 월을 12로 년도는 감소 --%>
	<c:if test="${month le 0 }">
		<c:set var="year" value="${year - 1 }" />
		<c:set var="month" value="12" />
	</c:if>
	<%-- 년도가 0이하이면 현재월로 변경 --%>
	<c:if test="${month le 0 }">
		<c:set var="year" value="${date.year+1900 }" />
	</c:if>
	<%-- 1일의 요일과 마지막 날짜 구하기 --%>
	<jsp:useBean id="util" class="kr.green.cal.DateUtil" />
	<c:set var="lastday" value="${util.getLastday(year,month)}" />
	<c:set var="week" value="${util.getWeekday(year,month,1)}" />
	<%-- URL 만들기 --%>
	<c:url var="prevYear" value="?">
		<c:param name="yy" value="${year-1 }" />
		<c:param name="mm" value="${month }" />
	</c:url>
	<c:url var="prevMonth" value="?">
		<c:param name="yy" value="${year }" />
		<c:param name="mm" value="${month-1 }" />
	</c:url>
	<c:url var="nextYear" value="?">
		<c:param name="yy" value="${year+1 }" />
		<c:param name="mm" value="${month }" />
	</c:url>
	<c:url var="nextMonth" value="?">
		<c:param name="yy" value="${year }" />
		<c:param name="mm" value="${month+1 }" />
	</c:url>
	<table>
		<tr>
			<td colspan="2" align="center"><a href="${prevYear }">◀</a> <a
				href="${prevMonth }">◁</a></td>
			<td colspan="3" align="center" style="font-size: 22pt;">${year }년
				${month }월</td>
			<td colspan="2" align="center"><a href="${nextMonth }">▷</a> <a
				href="${nextYear }">▶</a></td>
		</tr>
		<tr>
			<c:forTokens items="일,월,화,수,목,금,토" delims="," var="s">
				<th>${s }</th>
			</c:forTokens>
		</tr>
		<tr>
			<%-- 1일의 요일 자리를 맞추기 위해 앞에 빈칸을 출력한다. --%>
			<c:forEach var="i" begin="1" end="${week-1 }">
				<td class='dateStyle'>&nbsp;</td>
			</c:forEach>
			<%-- 1일부터 마지막 날짜까지 출력 --%>
			<c:forEach var="i" begin="1" end="${lastday }">
				<td class='dateStyle'>${i }</td>
				<c:set var="week" value="${util.getWeekday(year,month,i)}" />
				<c:if test="${week eq 7 }">
					</tr>
					<c:if test="${i lt lastday }">
						<tr>
					</c:if>
				</c:if>
			</c:forEach>
		<%-- 표의 뒷 부분 마무리 --%>
		<%-- 마지막 날짜의 요일이 토요일이 아니면 빈칸 출력 --%>
		<c:if test="${week lt 7 }">
			<c:forEach var="i" begin="${week }" end="6">
				<td class='dateStyle'>&nbsp;</td>
			</c:forEach>
			</tr>
		</c:if>
		</tr>
	</table>
</body>
</html>