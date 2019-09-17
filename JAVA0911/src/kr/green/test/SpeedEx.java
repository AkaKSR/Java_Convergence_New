package kr.green.test;
/*
 * 문자열 연산이 만을 경우에는 StringBuffer, StringBuilder를 사용해야 한다.
 * String은 연산시 항상 새로운 객체를 만들어 리턴하므로 메모리를 너무 많이 사용한다.
 * 하지만 StringBuffer, StringBuilder는 자신이 스스로 변하므로 객체가 1개이다.
 * StringBuffer, StringBuilder의 차이는 스레드에 안전한가이다.
 * StringBuffer는 멀티 스레드에 안전하게 설계되었고
 * StringBuilder는 싱글 스레드에만 안전하게 설계되었다.
 */
public class SpeedEx {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuilder sb2 = new StringBuilder();
		
		String str="";
		long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) sb1.append("꽝");
		long end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (end-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) sb2.append("꽝");
		end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (end-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) str += "꽝";
		end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (end-start) + "ms");
	}
}
