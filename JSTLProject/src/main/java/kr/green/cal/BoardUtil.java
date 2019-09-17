package kr.green.cal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TreeSet;

public class BoardUtil {
	// 게시판에 날짜를 출력하는데 사용되는 메서드들
	public static String dateFormat1(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		return sdf.format(date);
	}
	
	public static String dateFormat2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(date);
	}
	
	public static String dateFormat3(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		return sdf.format(date);
	}
	
	public static String lotto() {
		TreeSet<Integer> set = new TreeSet<>();
		Random rnd = new Random();
		while (set.size()<6) {
			set.add(rnd.nextInt(45)+1);
		}
		return set.toString();
	}
	
}
