package kr.green.cal;

public class DateUtil {
	/*
	 * 윤년을 판단하는 메서드
	 * 윤년은 년도가 400의 배수면 윤년이다.
	 * 또는
	 * 년도가 4의 배수이미녀서 100의 배수가 아니면 윤년이다.
	 */
	public static boolean isLeapYear(int year) {
		return year%400==0 || year%4==0 && year%100!=0;
	}
	// 해당 월의 마지막 날짜를 구해주는 메서드
	public static int getLastday(int year, int month) {
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year)) m[1] = 29; // 윤년이면 2월을 29일로 만든다.
		return m[month-1];
	}
	// 해당 일까지의 총 일수를 구하는 메서드
	public static int getTotalday(int year, int month, int day) {
		// 1. 전년도까지의 일수
		int total = (year-1) * 365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		// 2. 전월까지의 일수
		for (int i = 1; i < month; i++) {
			total +=getLastday(year, i);
		}
		// 3. 더하기 1
		total += day;
		
		return total;
	}
	// 요일을 구해주는 메서드
	public static int getWeekday(int year, int month, int day) {
		return getTotalday(year, month, day)%7 + 1;
	}
}
