<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {
		border: 1px solid gray;
	}
	#menu {
		width: 200px;
		height: 960px;
	}
	#content {
		width: 810px;
	}
</style>
</head>
<body>
	<div align="center">
		<!-- 상단 패널(top.jsp) 노출 부분 -->
		<jsp:include page="top.jsp"></jsp:include>
		<hr>
		<table>
			<tr>
				<!-- 메뉴 패널(menu.jsp) 노출 부분 -->
				<td id="menu">
				<jsp:include page="menu.jsp"></jsp:include>
				</td>
				<!-- 컨텐츠 패널(content.jsp) 노출 부분 -->
				<td id="content">
				<jsp:include page="content.jsp"></jsp:include>
				<!-- 로그인 패널(login.jsp) 노출 부분 -->
				<%@ include file="login.jsp"%>
				</td>
			</tr>
		</table>
		<hr>
		<!-- 하단 패널(bottom.jsp) 노출 부분 -->
		<jsp:include page="bottom.jsp"></jsp:include>
	</div>
</body>
</html>