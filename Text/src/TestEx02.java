import java.util.Scanner;

public class TestEx02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ar = new int[26];
		while (true) {
			System.out.print("소문자로 이루어진 긴 영문장을 입력(0은 종료)");
			String str = sc.nextLine();
			str = str.toLowerCase();
			if (str.charAt(0) == '0') break;
			for (int i = 0; i < ar.length; i++) ar[i] = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch<'a' || ch>'z') continue;
				System.out.println(ch);
				ar[ch-'a']++;
			}
			
			for (int i = 0; i < ar.length; i++) {
				System.out.println((char)(i+'a') + "의 갯수 : " + ar[i]);
			}
		}
		sc.close();
	}
}
