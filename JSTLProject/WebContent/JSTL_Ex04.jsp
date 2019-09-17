<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10">
		<div style="font-size: ${i*5}pt">야호</div>
	</c:forEach>
	월 선택 :
	<select>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
	</select>
	<br>
	월 선택 : 
	<select>
	<%-- step은 var="i"의 증가치를 설정하는 부분 --%>
		<c:forEach var="i" begin="1" end="12" step="1">
			<option value="${i }">${i }</option>
		</c:forEach>
	</select>
</body>
</html>