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
			var name = $("#name").val();
			var age = $("#age").val();
			$.ajax({ // ajax
				url : 'hello.jsp',
				data : {"name":name, "age":age},
				type : "POST",
				success : function(data) {
					$("#content").html(data);
				},
				error : function() {
					$("#content").html("<span style=color:red;>주소 확인해</span>");
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
	이름 : <input type="text" name="name" id="name"/><br>
	나이 : <input type="text" name="age" id="age"/><br>
	<button id="btn">서버 전송</button><br>
	<hr>
	<div id="content"></div>
</body>
</html>