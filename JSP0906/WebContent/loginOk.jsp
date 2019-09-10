<%@page import="kr.green.cookie.CookieUtil"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="kr.green.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("index.jsp"); // 사이트의 시작페이지로 보내기
		return;
	}
	// 이전페이지 알아내기!!!
	String referer = request.getHeader("referer");
	
	// 데이터 받고
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String saveID = request.getParameter("saveID");
	
	// 넘어온 값에 <, >, ||, && 문자가 들어있으면 뒤로 보낸다.
	String word[] = "<,>,||,&&,!".split(",");
	for(String t : word) {
		if(userid.contains(t)) {
			out.println("<script>");
			out.println("alert('밑장빼다 걸리면 손모가지 날아간다고 안배웠냐?');");
			out.println("location.href='" + referer +"';");
			out.println("</script>");
		}
	}
	for(String t : word) {
		if(password.contains(t)) {
			out.println("<script>");
			out.println("alert('밑장빼다 걸리면 손모가지 날아간다고 안배웠냐?');");
			out.println("location.href='" + referer +"';");
			out.println("</script>");
		}
	}

	// 회원정보 읽고
	Gson gson = new Gson();
	InputStreamReader isr = new InputStreamReader(application.getResourceAsStream("member.json"));
	List<MemberVO> list = gson.fromJson(isr, new TypeToken<List<MemberVO>>(){}.getType());
	
	// 로그인 처리
	boolean flag = false;
	
	for(MemberVO vo : list){
		if(vo.getUserid().equals(userid)){
			flag = true;
			if(vo.getPassword().equals(password)){ 
				// 아이디와 암호가 일치하면
				session.setAttribute("member", vo);
				// 아이디 자동 저장을 선택했다면
				if(saveID!=null && saveID.equals("1")){
					// 쿠키 저장
					response.addCookie(CookieUtil.createCookie("userid", vo.getUserid(), 60*60*24*7));
				}else{
					// 쿠키 삭제
					CookieUtil cookieUtil = new CookieUtil(request);
					cookieUtil.deleteCookie(response, "userid");
				}
				// 그리고 원래 페이지로 간다.
				response.sendRedirect(referer);
				return;
			}else{
				// 아이디는 있는데 암호가 틀리면
				out.println("<script>");
				out.println("alert('비번을 확인하세요');");
				out.println("location.href='" + referer +"';");
				out.println("</script>");
			}
		}
	}
	if(!flag){
		// 아이디가 존재하지 않는다. 
		out.println("<script>");
		out.println("alert('존재하지 않는 아이디 입니다.');");
		out.println("location.href='" + referer +"';");
		out.println("</script>");
	}
%>







