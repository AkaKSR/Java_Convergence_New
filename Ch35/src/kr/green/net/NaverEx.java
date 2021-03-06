package kr.green.net;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverEx {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.naver.com/").get();
			System.out.println(doc.title());
			Elements lis = doc.select("div.ah_roll_area ul li");
			System.out.println(lis.size() + "개");
			
			for (Element e : lis) {
				System.out.println(e.text());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
