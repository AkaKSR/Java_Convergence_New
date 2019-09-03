import java.util.Scanner;

/*
 * 자연수 N을 입력받아서 각 자리수의 합이 한자리가 될 때까지 그 합을 출력하는 프로그램을 작성하시오.
 * 양의 정수 N을 입력받는다.
 * 첫 번째 줄에 입력받은 수의 각 자리수의 합을 출력한다.
 * 출력한 수가 10 이상이면 그 수의 각 자리수의 합을 다음줄에 출력한다.
 * 출력한 수가 10 미만이 될 때까지 반복하여 출력한다.
 * 
 * 입력 : 1234567891
 * 출력 : 
 * 46
 * 10
 * 1
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("정수입력(0은 종료) > ");
			int num = sc.nextInt();
			if (num==0) break;
			int sum = num;
			do {
				int temp = sum;
				sum=0;
				while (temp > 0) {
					sum += temp % 10;
					temp /= 10;
				}
				System.out.println(sum);
			} while (sum>=10);
		}
		sc.close();
	}
}
