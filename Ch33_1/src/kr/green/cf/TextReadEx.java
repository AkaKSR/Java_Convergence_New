package kr.green.cf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReadEx {
	
	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("chunja.txt"));
			while (sc.hasNextLine()) {
				String hanja[] = sc.nextLine().split("\\|");
				System.out.println(hanja[0] + ". " + hanja[1] + "(" + hanja[3] + ")");
//				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
