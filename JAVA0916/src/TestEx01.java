import java.util.Scanner;

/*
 * 5개의 자연수를 입력받아 소수인지 합성수인지를 판단하는 프로그램을 작성하시오.
 * 조건1: 소수는 1보다 큰 자연수 중 1과 자기 자신 두 개만을 약수로 갖는 수
 * 조건2: 합성수는 1보다 큰 자연수 중 소수가 아닌 수를 말하며 3개 이상의 약수를 갖는 수
 * 
 * 1 3 5 7 11 13 17 19
 */
public class TestEx01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int[5];

		// 5개의 자연수 입력받기
		for (int i = 0; i < num.length; i++) {
			System.out.print((i + 1) + "번째 자연수를 입력하세요 > ");
			num[i] = sc.nextInt();
		}
		// 입력받은 자연수를 이용하여 소수 판별하기
		int j = 1;
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 1) {
				System.out.println("1입니다.");
			} else {
				while (num[i] % (j+1) == 0) {
					System.out.println("asdfdasd");
				}
			}
			
			
			if (num[i] % 2 == 0) {
				System.out.println((i + 1) + "번째 자연수 " + num[i] + "는 소수가 아닙니다.");
			} else if (num[i] % 3 == 0) {
				System.out.println((i + 1) + "번째 자연수 " + num[i] + "는 소수가 아닙니다.");
			} else if (num[i] % 4 == 0) {
				System.out.println((i + 1) + "번째 자연수 " + num[i] + "는 소수가 아닙니다.");
			} else {
				System.out.println((i + 1) + "번째 자연수 " + num[i] + "는 소수가 맞습니다.");
			}
		}
	}
}
