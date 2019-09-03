<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 등록하기</title>
<style type="text/css">
	table {
		width: 600px; margin: auto; border: 1px solid gray;
	}
	td{ border: 0px solid gray; padding: 3px;}
	th{ border: 0px solid gray; padding: 3px; background-color: silver;}
</style>
</head>
<body>
	<form action="pollInsertOk.jsp" method="post">
		<table>
			<tr>
				<td align="center" colspan="2" style="font-size: 18pt;">설문 등록 하기</td>
			</tr>
			<tr>
				<td align="right">제목</td>
				<td><input type="text" name="subject" size="40" required="required"> </td>
			</tr>
			<% for(int i=0;i<10;i++){ %>
			<tr>
				<td align="right">항목 <%=(i+1) %></td>
				<td><input type="text" name="item" size="70"> </td>
			</tr>
			<% } %>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="저장하기">
					<input type="button" value="돌아가기" onclick="location.href='pollList.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>