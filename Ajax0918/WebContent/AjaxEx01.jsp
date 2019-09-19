<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		// Ajax 객체 생성
		var xhttp = new XMLHttpRequest();
		// 객체의 상태가 변경되면 실행할 함수 지정
		xhttp.onreadystatechange = function() {
			// 응답이 완료되고 응답 상태가 성공이면
			if (this.readyState == 4 && this.status == 200) {
				// 받은 내용을 content에 넣어라
				document.getElementById("content").innerHTML = this.responseText;
			}
		};
		// 연결 준비
		xhttp.open("GET", "msg.txt", true);
		// 연결
		xhttp.send();
	}
</script>
</head>
<body>
	Ajax (Asynchronous JavaScript And XML.)
	<div id="content">
		<h1>하하하</h1>
	</div>
	<button onclick="loadDoc()">내용 변경하기</button>
	<br> 호호호호
</body>
</html>