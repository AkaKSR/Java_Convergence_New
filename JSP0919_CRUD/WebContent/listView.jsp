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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#insertBtn").click(function() {
			location.href = 'insertForm.jsp';
		});
	});
</script>
<style type="text/css">
	table {
		width: 700px;
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
			<td class="title" colspan="5">메모장</td>
		</tr>
		<tr>
			<td align="right" colspan="5" style="border: none;">전체 ${list.size() }개(0/00 Page)</td>
		</tr>
		<tr align="center" style="border: 1px solid gray;">
			<th>No</th>
			<th>이름</th>
			<th width="60%">메모</th>
			<th>작성일</th>
			<th>IP</th>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<td align="center" colspan="5" style="border: none;">등록된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="vo" items="${list }">
				<tr align="center" style="border: 1px solid gray;">
					<td>${vo.idx }</td>
					<td>
						<c:out value="${vo.name }"></c:out>
					</td>
					<td align="left">
						<c:out value="${vo.memo }"></c:out>
						<button onclick="location.href='updateForm.jsp?idx=${vo.idx}'">수정</button>
						<button onclick="location.href='deleteForm.jsp?idx=${vo.idx}'">삭제</button>
					</td>
					<td>
						<fmt:formatDate value="${vo.regDate }" pattern="MM-dd hh:mm"/>
					</td>
					<td>${vo.ip }</td>
				</tr>
			</c:forEach>
			<%-- 여기에 페이지 이동하는 링크 존재 --%>
		</c:if>
		<%-- 쓰기 버튼 --%>
		<tr>
			<td align="right" colspan="5">
				<button class="btn btn-primary btn-sm" id="insertBtn">쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>