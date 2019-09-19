<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery Ajax</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			// Ajax 객체 생성
			var xhttp = new XMLHttpRequest();
			// 객체의 상태가 변경되면 실행할 함수 지정
			xhttp.onreadystatechange = function() {
				// 응답이 완료되고 응답 상태가 성공이면
				if (this.readyState == 4 && this.status == 200) {
					// 데이터를 XML로 받기
					var xmlDoc = this.responseXML;
					// XML문서에서 필요한 데이터를 얻어야 한다.
					var result = "";
					// Jquery를 이용한 XML 파싱
					var xmlData = $(xmlDoc).find("food");
					$(xmlData).each(function() {
						result += "이름: " + $(this).find("name").text() + "<br>";
						result += "가격: " + $(this).find("price").text() + "<br><hr>";
					});
					// 받은 내용을 content에 넣어라
					document.getElementById("result").innerHTML = result;
				}
			};
			// 연결 준비
			xhttp.open("GET", "food.xml", true);
			// 연결
			xhttp.send();
		});
	});
</script>
<style type="text/css">
	div {
		height: 500px;
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<button id="btn">XML 불러오기</button>
	<br><hr>
	<div id="result">
	</div>
</body>
</html>