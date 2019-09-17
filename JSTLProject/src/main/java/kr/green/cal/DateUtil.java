package kr.green.cal;

public class DateUtil {
	// 윤년을 판단하는 메서드
	// 년도가 400의 배수면 윤년
	// 또는
	// 년도가 4의 배수 이면서 100의 배수가 아니면 윤년
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}

	// 해당월의 마지막 날짜를 구해주는 메서드
	public static int getLastday(int year, int month) {
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year))
			m[1] = 29; // 윤년이면 2월을 29일 만든다.
		return m[month - 1];
	}

	// 해당일까지 총일수를 구하는 메서드
	public static int getTotalday(int year, int month, int day) {
		// 1. 전년도까지의 일수
		int total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		// 2. 전월까지의 일수
		for (int i = 1; i < month; i++)
			total += getLastday(year, i);
		// 3. 더하기 일
		total += day;
		return total;
	}

	// 요일을 구해주는 메서드
	public static int getWeekday(int year, int month, int day) {
		return getTotalday(year, month, day) % 7 + 1;
	}

	// 달력을 출력하는 메서드
	public static String viewCalendar(int year, int month) {
		StringBuilder sb = new StringBuilder();
		sb.append("<style type='text/css'>");
		sb.append("table { width: 350px; margin: auto;border: 0px solid gray;padding: 5px; }");
		sb.append("th { background-color: silver; padding:5px; width: 50px;}");
		sb.append(".dateStyle{ border: 1px solid gray;padding: 5px; padding:5px; font-size: 12pt;text-align: right;}");
		sb.append("</style>");
		sb.append("<table>");
		sb.append("<tr><td colspan='7' align='center'>" + year + "년 " + month + "월</td></tr>");
		sb.append("<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr>");
		sb.append("<tr>");
		for (int i = 1; i < getWeekday(year, month, 1); i++) {
			sb.append("<td class='dateStyle'>&nbsp;</td>");
		}
		for (int i = 1; i <= getLastday(year, month); i++) {
			sb.append("<td class='dateStyle'>" + i + "</td>");
			if (getWeekday(year, month, i) == 7) {
				sb.append("</tr>");
				if (i < getLastday(year, month)) {
					sb.append("<tr>");
				}
			}
		}
		int w = getWeekday(year, month, getLastday(year, month));
		if (w < 7) {
			for (int i = w; i <= 6; i++) {
				sb.append("<td class='dateStyle'>&nbsp;</td>");
			}
			sb.append("</tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}

}
