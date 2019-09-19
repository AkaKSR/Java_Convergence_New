<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery Ajax</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.ajax("food.xml",{ success : function(data) {
				$(data).find("food").each(function() {
					$("#content").append("이름: " + $(this).find("name").text() + "<br>");
					$("#content").append("가격: " + $(this).find("price").text() + "<br><hr>");
				});
			}});// ajax
		}); // click
	});// onload
</script>
<style type="text/css">
	div{border: 1px solid gray;}
</style>
</head>
<body>
	<button id="btn">XML 받기</button>
	<br><hr>
	<div id="content"></div>
</body>
</html>