<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	나는 from입니다. <br>
	나는 from입니다. <br>
	나는 from입니다. <br>
	<%-- 
	html코드 내에서 사용하는 방법
	<jsp:forward page="to.jsp"></jsp:forward>
	--%>
	<%
		// jsp페이지의 코드 영역에서 사용하는 방법
		// pageContext.forward("to.jsp");
	
		// pageContext를 사용할 수 없는 곳에서 사용 --- 서블릿
		RequestDispatcher dispatcher = request.getRequestDispatcher("to.jsp");
		dispatcher.forward(request, response);
	%>
	나는 from입니다. <br>
	나는 from입니다. <br>
	나는 from입니다. <br>
</body>
</html>