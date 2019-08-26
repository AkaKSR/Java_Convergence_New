package kr.green.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ViewWebSource {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("https://www.naver.com");
			Scanner sc = new Scanner(url.openStream(), "UTF-8");
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}