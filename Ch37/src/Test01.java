import java.util.Scanner;

/*
 * 강아지와 병아리의 합과 다리의 수를 입력받아 강아지와 병아리가 각각 몇마리씩인지 구하는 프로그램을 작성하시오.
 * 
 * 강아지와 병아리의 합이 1000 이하 다리의 합이 4000 이하의 음수가 아닌 정수가 공백으로 구분하여 입력된다.
 * 하나의 결과가 나온 후에도 계속 새로운 입력을 받아가 0 0 이 입력되면 프로그램을 종료한다.
 * 
 * 강아지와 병아리가 각각 몇 마리씩인지 공백으로 구분하여 출력한다.
 * 주어진 데이터로 마리수를 정할 수 없을 때는 0을 출력한다.
 * 데이터의 크기가 주어진 범위를 벗어날 경우는 INPUT ERROR!을 출력한다.
 * 
 *  입력			출력
 *  25 80			15 10
 *  15 10			0
 *  1500 20000		INPUT ERROR!
 *  0 0
 */
public class Test01 {
	public static void main(String[] args) {
		int dog, chick;
		String[] sum = new String[2];
		String input;
		boolean bFlag = true;
		Scanner sc = new Scanner(System.in);

		while (bFlag) {
			System.out.print("강아지와 병아리의 합과 다리의 합을 입력하시오 > ");
			input = sc.nextLine();
			
			// input을 " "로 split하는 구문
			for (int i = 0; i < 2; i++) {
				sum = input.split(" ");
			}
			
			// TODO 분리된 값을 int로 형변환 하고 거기서부터 각각 계산하는 로직 작성해야됨.
			
			// 결과물 출력(Test Code)
			for (int i = 0; i < sum.length; i++) {
				System.out.println(sum[i]);
			}
		}
		sc.close();
	}
}
