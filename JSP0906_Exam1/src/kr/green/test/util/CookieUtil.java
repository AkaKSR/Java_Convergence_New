package kr.green.test.util;

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

	public boolean hasCookie(String name) {
		return cookieMap.containsKey(name);
	}

	public String getCookie(String name) {
		if (hasCookie(name)) {
			return cookieMap.get(name);
		} else {
			return null;
		}
	}

	public void deleteCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		cookieMap.remove(name);
	}

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
