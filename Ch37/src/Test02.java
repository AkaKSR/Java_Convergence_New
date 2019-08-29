import java.util.Scanner;
/*
 * Test01의 정답
 */
public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int puppy = 0, chick = 0;
		int animalSum = 1, legSum = 0;
		while (true) {
			System.out.print("동물의 합과 다리의 합을 공백으로 구분하여 입력(0 0은 종료) > ");
			animalSum = sc.nextInt();
			legSum = sc.nextInt();
			if (animalSum == 0 && legSum == 0) break;
			if (animalSum <= 0 || animalSum > 1000 || legSum < 0 || legSum > 4000) {
				System.out.println("INPUT ERROR!");
				continue;
			}
			boolean flag = false;
			loop:
				for (puppy = 1; puppy <= animalSum; puppy++) {
					for (chick = 1; chick <= animalSum; chick++) {
						if ((puppy*4 + chick*2) == legSum && puppy+chick == animalSum) {
							flag = true;
							break loop;
						}
					}
				}
			if (flag) {
				System.out.println(puppy + " " + chick);
			} else {
				System.out.println("0");
			}
		}
	}
}
