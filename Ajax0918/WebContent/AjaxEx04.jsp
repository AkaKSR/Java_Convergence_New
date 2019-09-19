<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	width: 400px;
	height: 100px;
	border: 1px solid gray;
}
</style>
<script type="text/javascript">
	function loadDoc() {
		var no = document.getElementById("no").value;
		// Ajax 객체 생성
		var xhttp = new XMLHttpRequest();
		// 객체의 상태가 변경되면 실행할 함수 지정
		xhttp.onreadystatechange = function() {
			// 응답이 완료되고 응답 상태가 성공이면
			if (this.readyState == 4 && this.status == 200) {
				var json = eval('(' + this.responseText + ')');
				document.getElementById("msg").innerHTML = json.h + ":" +  json.m;
			}
		};
		// 연결 준비
		xhttp.open("GET", "chunja.jsp?no=" + no, true);
		// 연결
		xhttp.send();
	}
</script>
</head>
<body>
	번호 : <input type="text" name="no" id="no" onkeyup="loadDoc();"> <span id="msg"></span>
</body>
</html>