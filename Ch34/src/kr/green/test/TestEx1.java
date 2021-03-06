/*
 * 문제
 * 1 1 2 3 5 8 13 21 34 55 ...
 * 피보나치 수열을 1줄에 5개씩 30개 출력하시오
 * 
 * 1. 변수 2개를 선언하여 0과 1로 초기화 한다.
 * 2. 두번째 변수 값을 출력한다.
 * 3. 개수가 5의 배수면 줄바꿈
 * 4. 임시 변수에 두번째 값을 피신 시킨다.
 * 5. 두개의 변수 값을 더해 두번째 변수에 넣는다.
 * 6. 임시 변수 값을 첫번째 변수에 넣는다.
 * 7. 개수가 30일때 까지 2~6을 반복한다.
 */

package kr.green.test;

public class TestEx1 {
	public static void main(String[] args) {
		int first = 0, second = 1, temp = 0, count = 0; // 1번 해결
		while (count < 30) {
			System.out.print(String.format("%8d", second)); // 2번 해결
			if (++count % 5==0) System.out.println(); // 3번 해결
//			temp = second; // 4번 해결
//			second = second + first; // 5번 해결
//			first = temp; // 6번 해결
			
			/*
			 * 4, 5, 6번 해결
			 */
			second = first + second;
			first = second - first;
			
		} // 7번 해결
	}
}
