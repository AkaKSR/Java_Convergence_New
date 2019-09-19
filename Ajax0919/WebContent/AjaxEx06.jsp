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
			$.ajax({ // ajax
				url : 'msg2.txt',
				success : function(data) {
					$("#result").html(data);
				},
				error : function() {
					$("#result").html("<span style=color:red;>주소 확인해</span>");
				}
			}); // ajax
		}); // click
	}); // onload
</script>
<style type="text/css">
div {
	height: 500px;
	border: 1px solid gray;
}
</style>
</head>
<body>
	<button id="btn">Text 불러오기</button>
	<br>
	<hr>
	<div id="result"></div>
</body>
</html>