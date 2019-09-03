import java.util.Scanner;

/*
 * 오늘의 문제
 * 세 개의 자연수 A, B, C가 주어질 때
 * AxBxC를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지 구하는 프로그램을 작성하시오.
 * 
 * 예를 들어 A = 150, B = 266, C = 427 이라면
 * AxBxC = 150 x 266 x 427 = 17037300 이 되고
 * 계산한 결과 17037300에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 * 
 * 유사 문제
 * 소문자로만 이루어진 긴 영문장을 입력하고 알파벳이 각각 몇 글자씩 있는지 출력하는 프로그램을 작성하시오.
 */
public class TestEx01 {
	public static void main(String[] args) {
		int[] a = new int[3];
		int result = 1;
		int count = 0;
		String input;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계산할 값을 입력해주시기 바랍니다 (ex 150 266 427) > ");
		input = sc.nextLine();
		String[] convert = input.split(" ");
		
		for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(convert[i]);
		
		for (int i = 0; i < a.length; i++) result *= a[i];
		System.out.println("Result: " + result);
		
		while (result > 0) {
			
		}
	}
}
