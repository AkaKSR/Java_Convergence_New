<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>욕설 필터링</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#memo").keyup(function() {
			var value = $(this).val();
			$.ajax({
				url : "wordFilter.jsp",
				data : {
					"data" : value
				},
				type : "POST",
				success : function(data) {
					if (data == 1) {
						alert('욕설은 입력할 수 없습니다.');
					}
				}
			}); // ajax
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
	메모
	<br>
	<textarea id="memo" cols="60" rows="10"></textarea>
</body>
</html>