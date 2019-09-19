<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery Ajax</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() { // onload
		$("#btn").click(function() { // click
			$.getJSON("chunja.json", function(data) { // getJSON
				$.each(data, function(i, item) {
					$("#content").append((i+1) + ". " + item.h + "(" + item.m + ")" + "<br>");
				});
			}); // getJSON
		}); // click
	}); // onload
</script>
<style type="text/css">
div {
	border: 1px solid gray;
}
</style>
</head>
<body>
	<button id="btn">실행하기</button><br><hr>
	<div id="content"></div>
</body>
</html>