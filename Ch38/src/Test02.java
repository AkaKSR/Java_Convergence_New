import java.util.Scanner;

/*
 * 월급을 입력받아 화폐단위별 매수를 출력하는 프로그램을 작성하시오.
 */
public class Test02 {
	public static void main(String[] args) {
		int input; // 값을 입력받을곳
		int m[] = { 1000000, 100000, 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 }; // 화폐단위 
		Scanner sc = new Scanner(System.in); // 스캐너 초기화
		
		while (true) { // while문 진입(무한)
			System.out.print("월급을 입력해주세요 (0은 종료) > "); // sysout
			input = sc.nextInt(); // input에 입력값 저장
			if (input == 0) break; // input의 값이 0 이라면 while문을 빠져나온다.
			for (int i = 0; i < m.length; i++) { // 0에서 m의 배열수만큼 반복
				System.out.println(String.format("%10d원권 : %5d매", m[i], input/m[i])); // 각각의 화폐단위와 매수를 출력하되 매수는 화폐단위만큼 나눈수를 매수에 출력한다.
				input = input%m[i]; // input에서 화폐단위만큼 나누고 나머지 값을 만든다.
			}
		}
		sc.close();
	}
}
