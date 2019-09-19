<%@ page language="java" contentType="text/plain; charset=UTF-8"
	trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userid = request.getParameter("userid");
	
	String[] members = "root,root1,admin,admin1,admin2,root2,master".split(",");
	// SQL로 작성시
	// "select count(*) from member where userid=" + userid
	boolean flag = true;
	for(String t : members) {
		if(t.equals(userid)) {
			flag = false;
			break;
		}
	}
	System.out.println(userid);
	System.out.println(flag);
	out.println(flag?0:1);
%>