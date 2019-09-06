<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	버퍼 크기 : <%=out.getBufferSize() %><br>
	남은 버퍼 크기 : <%=out.getRemaining() %><br>
	자동 보내기 : <%=out.isAutoFlush() %><br>
	<%
		for(int i = 0; i<1000;i++) {
			out.println(i + "<br>");
			// autoFlush가 거짓이면 출력할때마다
			// flush()를 해줘야 한다.
			if(out.getRemaining()<100) {
				out.flush();
			}
		}
	%>
</body>
</html>