<%@page import="kr.green.test.util.CookieUtil"%>
<%@page import="kr.green.test.vo.MemberVO"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 인코딩 변경(UTF-8)
	request.setCharacterEncoding("UTF-8");
	// post 접근인지 아닌지 확인
	if (!request.getMethod().equals("POST")) {
		response.sendRedirect("index.jsp");
		return;
	}

	// referer 얻어내기
	String referer = request.getHeader("referer");

	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String saveID = request.getParameter("saveID");

	// SQL Injection 방지
	String word[] = "<,>,||,&&,!".split(",");
	// ID 부분 체크
	for (String t : word) {
		if (userid.contains(t)) {
			out.println("<script>");
			out.println("alert('밑장빼다 걸리면 손모가지 날아간다고 안배웠냐?')");
			out.println("location.href='" + referer + "';");
			out.println("</script>");
		}
	}
	// Password 부분 체크
	for (String t : word) {
		if (password.contains(t)) {
			out.println("<script>");
			out.println("alert('밑장빼다 걸리면 손모가지 날아간다고 안배웠냐?')");
			out.println("location.href='" + referer + "';");
			out.println("</script>");
		}
	}

	Gson gson = new Gson();
	InputStreamReader isr = new InputStreamReader(application.getResourceAsStream("member.json"));
	List<MemberVO> list = gson.fromJson(isr, new TypeToken<List<MemberVO>>() {
	}.getType());

	boolean flag = false;

	for (MemberVO vo : list) {
		if (vo.getUserid().equals(userid)) {
			flag = true;
			if (vo.getPassword().equals(password)) {
				session.setAttribute("member", vo);
				if (saveID != null && saveID.equals("1")) {
					// 쿠키 저장
					response.addCookie(CookieUtil.createCookie("userid", vo.getUserid(), 60 * 60 * 24 * 7));
				} else {
					// 쿠키 삭제
					CookieUtil cookieUtil = new CookieUtil(request);
					cookieUtil.deleteCookie(response, "userid");
				}
				// 원래 페이지로 리다이렉트
				response.sendRedirect(referer);
				return;
			} else {
				// 아이디 O 비번 X
				out.println("<script>");
				out.println("alert('비번을 확인해주세요.');");
				out.println("location.href='" + referer + "';");
				out.println("</script>");
			}
		}
	}
	if(!flag) {
		// 아이디 X
				out.println("<script>");
				out.println("alert('존재하지 않은 계정입니다.');");
				out.println("location.href='" + referer + "';");
				out.println("</script>");
	}
%>