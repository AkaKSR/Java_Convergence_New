<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- request.getParameter를 대신하는게 ${param.변수명 }이다. --%>
	<%
		String name = request.getParameter("name");
	int age = 0;
	try {
		age = Integer.parseInt(request.getParameter("age"));
	} catch(Exception e) {
		;
	}
	String ar[] = request.getParameterValues("a");
	
	%>
	
	이름 : <%=name %><br>
	나이 : <%=age %><br>
	<%=name %>씨 내년 나이는 <%=(age+1) %>입니다. <br>
	a로 전달된 값 : 
	<%
		if(ar!=null && ar.length>0) {
			for(String t : ar) {
				out.println(t + " ");
			}
		} else {
			out.println("읎다.");
		}
	%>
	<br>
	<hr>
	이름 : ${param.name }<br>
	나이 : ${param.age }<br>
	${param.name }씨 내년 나이는 ${param.age+1 }입니다. <br>
	a로 전달된 값 : ${empty paramValues.a ? "없다" : paramValues.a }
</body>
</html>