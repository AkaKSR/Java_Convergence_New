<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 800px;
	margin: auto;
	border: none;
}

.title {
	font-size: 18pt;
	text-align: center;
	border: none;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td class="title" colspan="5">허접한 메모장 Ver 0.009</td>
		</tr>
		<tr>
			<td align="right" colspan="5" style="border: none;">전체:
				00개(00/00)</td>
		</tr>
		<tr>
			<th width="10%">번호</th>
			<th width="10%">이름</th>
			<th>메모</th>
			<th width="15%">작성일</th>
			<th width="15%">IP</th>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<td align="center" colspan="5">데이터가 존재하지
					않습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="vo" items="${list }">
				<tr align="center">
					<td>${vo.idx }</td>
					<td>
						<c:out value="${vo.name }"/>
					</td>
					<td align="left">
						&nbsp;<c:out value="${vo.memo }"/>
					</td>
					<td>
						<fmt:formatDate value="${vo.regDate }" pattern="MM-dd"/>
					</td>
					<td>${vo.ip }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>