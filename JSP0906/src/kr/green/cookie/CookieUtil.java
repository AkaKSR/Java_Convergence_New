package kr.green.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private Map<String, String> cookieMap = new HashMap<>();

	public CookieUtil(HttpServletRequest request) {
		// 생성자에서 모든 쿠키를 읽어서 맵에 저장해두자
		Cookie[] cookies = request.getCookies();
		if (cookies != null & cookies.length > 0) {
			for (Cookie cookie : cookies) {
				try {
					cookieMap.put(cookie.getName(), URLDecoder.decode(cookie.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 쿠키를 만들어주는 정적 메서드를 만들자
	public static Cookie createCookie(String name, String value) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			cookie.setMaxAge(maxAge);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookie;
	}

	public static Cookie createCookie(String name, String value, String path, int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			cookie.setPath(path);
			cookie.setMaxAge(maxAge);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookie;
	}

	public static Cookie createCookie(String name, String value, String path, String domain, int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			cookie.setDomain(domain);
			cookie.setPath(path);
			cookie.setMaxAge(maxAge);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookie;
	}

	// 해당 쿠키가 존재하는지 확인해보자
	public boolean hasCookie(String name) {
		return cookieMap.containsKey(name);
	}

	// 해당 쿠키 값을 읽어오는 메서드
	public String getCookie(String name) {
		if (hasCookie(name)) {
			return cookieMap.get(name);
		} else {
			return null;
		}
	}

	// 해당 쿠키를 삭제하는 메서드
	public void deleteCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		cookieMap.remove(name);
	}

	// 해당 쿠키를 수정하는 메서드
	public void updateCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie;
		try {
			cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			response.addCookie(cookie);
			cookieMap.put(name, value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getCookieMap() {
		return cookieMap;
	}

	public void setCookieMap(Map<String, String> cookieMap) {
		this.cookieMap = cookieMap;
	}

	@Override
	public String toString() {
		return "CookieUtil [cookieMap=" + cookieMap + "]";
	}
}
