package kr.green.cf;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoEx04 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 게임?");
		int game = sc.nextInt();
		
		while (game>0) {
			lotto();
			game--;
		}
	}

	private static void lotto() {
		TreeSet<Integer> lotto = new TreeSet<>();
		Random rnd = new Random();
		
		lotto.clear();
		while (lotto.size() < 6) {
			lotto.add(new Random().nextInt(45) + 1);
		}
		System.out.println("로또번호 : " + lotto);
	}
	
}
