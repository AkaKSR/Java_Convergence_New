package kr.green.cal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LunarUtil {
	// 1개월치의 음력을 읽어서 리스트로 리턴하는 메서드
	public static List<LunarVO> getList(int year, int month) {
		List<LunarVO> list = new ArrayList<>();
		String address = "https://astro.kasi.re.kr/life/pageView/5?";
		address += String.format("search_year=%4d&search_month=%02d", year, month);
		
		Document doc;
		try {
			doc = Jsoup.connect(address).get();
			Elements trs = doc.select("table tbody tr");
			for(Element tr : trs) {
				String solar = tr.select("td").get(0).text(); // 양력
				String lunar = tr.select("td").get(1).text(); // 양력
				String ganji = tr.select("td").get(2).text(); // 양력
				list.add(new LunarVO(solar, lunar, ganji));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
