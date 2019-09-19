<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery Ajax</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#no").keyup(function(){
			var value = $(this).val();
			$.getJSON("chunja.jsp",{no:value}, function(data) {
				// alert(JSON.stringify(data));
				// document.getElementById("content").innerHTML = JSON.stringify(data);
				$("#content").html(data.h + "(" + data.m + ")");
			});// getJSON
		}); // click
	});// onload
</script>
<style type="text/css">
	div{border: 1px solid gray;height: 100px;}
</style>
</head>
<body>
	<input type="text" id="no">
	<br><hr>
	<div id="content"></div>
</body>
</html>