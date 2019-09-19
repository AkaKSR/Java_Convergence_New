<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#form").submit(function() {
			var value = $("#name").val();
			if (value.trim().length == 0) {
				alert('이름을 정확하게 입력해주시기 바랍니다.');
				$("#name").val("");
				$("#name").focus();
				return false;
			}
			var value = $("#password").val();
			if (value.trim().length == 0) {
				alert('암호를 정확하게 입력해주시기 바랍니다.');
				$("#password").val("");
				$("#password").focus();
				return false;
			}
			var value = $("#memo").val();
			if (value.trim().length == 0) {
				alert('메모를 정확하게 입력해주시기 바랍니다.');
				$("#memo").val("");
				$("#memo").focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form action="insertOk.jsp" method="post" id="form">
		<div class="form-group">
			<input type="text" class="form-control" id="name" name="name" placeholder="이름 입력" required="required">
			<input type="password" class="form-control" id="password" name="password" placeholder="암호 입력" required="required">
			<input type="text" class="form-control" id="memo" name="memo" placeholder="내용 입력" required="required">
		</div>
		<button type="submit" class="btn btn-primary btn-sm">저장하기</button>
	</form>
</body>
</html>