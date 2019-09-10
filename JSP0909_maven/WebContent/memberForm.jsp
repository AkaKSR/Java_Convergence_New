<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="memberOk2.jsp" method="post">
	<fieldset>
		<legend>회원가입</legend>
		사용자 아이디 : <input type="text" name="userid" id="userid" required="required"><br>
		사용자 비  번 : <input type="password" name="password" id="password" required="required"><br>
		사용자 이  름 : <input type="text" name="name" id="name" required="required"><br>
		사용자 나  이 : <input type="text" name="age" id="age" required="required"><br>
		사용자 성  별 : <label><input type="radio" name="gender" value="true">남자</label>
						<label><input type="radio" name="gender" value="false">여자</label><br>
		사용자 주  소 : <input type="text" name="address" id="address" size="80"><br>
		사용자 이메일 : <input type="text" name="email" id="email" size="60"><br>
		<input type="submit" value="회원가입">
	</fieldset>
</form>
</body>
</html>