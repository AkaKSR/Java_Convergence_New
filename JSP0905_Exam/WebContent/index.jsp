<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document Library</title>
<style type="text/css">
table {
	border: 1px solid gray;
}

tr {
	border: 1px solid gray;
}

td {
	border: 1px solid gray;
}
</style>
</head>
<body>

	<div>
		<table>
			<tr>
				<td colspan="2"
					style="text-align: center; width: 1280px; height: 200px; border: none;" id="top">
					<jsp:include page="top.jsp"></jsp:include>
					</td>
			</tr>
			<tr>
				<td id="leftSide" style="width: 1px; height: 960px;" align="center">
				<jsp:include page="leftSide.jsp"></jsp:include>
				</td>
				<td style="text-align: center;">menu$.jsp</td>
			</tr>
			<tr>
				<td colspan="2"
					style="text-align: center; width: 1280; height: 100px;" id="bottom">
					<jsp:include page="bottom.jsp"></jsp:include>
					</td>
			</tr>
		</table>
	</div>

</body>
</html>
<!--
			<jsp:include page="top.jsp"></jsp:include>
			index.jsp
			<hr>
			<jsp:include page="bottom.jsp"></jsp:include>
			 -->