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
		var userid = document.getElementById("userid").value;
		if(userid.length < 4) {
			document.getElementById("msg").innerHTML = "";
			return; // 4자이하는 처리하지 않는다.
		}
		// Ajax 객체 생성
		var xhttp = new XMLHttpRequest();
		// 객체의 상태가 변경되면 실행할 함수 지정
		xhttp.onreadystatechange = function() {
			// 응답이 완료되고 응답 상태가 성공이면
			if (this.readyState == 4 && this.status == 200) {
				if(this.responseText==0){
					document.getElementById("msg").innerHTML = "사용가능";
					document.getElementById("msg").style.color = 'blue';
				}else{
					document.getElementById("msg").innerHTML = "사용불가능";
					document.getElementById("msg").style.color = 'red';
				}
			}
		};
		// 연결 준비
		xhttp.open("GET", "idCheck.jsp?userid=" + userid, true);
		// 연결
		xhttp.send();
	}
</script>
</head>
<body>
	아이디 : <input type="text" name="userid" id="userid" onkeyup="loadDoc();"><span id="msg"></span>
</body>
</html>