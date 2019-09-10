<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("gender"));
		} catch(Exception e) {
			age = 0;
		}
		boolean gender = true;
		try {
			gender = Boolean.parseBoolean(request.getParameter("gender"));
		} catch(Exception e) {
			gender = true;
		}
		
		String address = request.getParameter("address");
		String email = request.getParameter("email");
	%>
	
	아이디 : <%=userid %> <br>
	비번 : <%=userid %> <br>
	이름 : <%=userid %> <br>
	나이 : <%=userid %> <br>
	성별 : <%=userid %> <br>
	주소 : <%=userid %> <br>
	이메일 : <%=userid %> <br>
</body>
</html>