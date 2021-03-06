package kr.green.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import kr.green.vo.BoxOfficeVO;
import kr.green.vo.DailyBoxOfficeList;

public class ViewBoxOffice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 날짜의 박스오피스 순위를 입력해주세요(ex 20190823) >> ");
		String date;
		try {
			date = sc.nextLine();
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=" + date);
			Gson gson = new Gson();
			InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8");
			BoxOfficeVO boxOffice = gson.fromJson(isr, BoxOfficeVO.class);
			
			System.out.println(boxOffice.getBoxOfficeResult().getBoxofficeType());
			System.out.println(boxOffice.getBoxOfficeResult().getShowRange());
			for (DailyBoxOfficeList d : boxOffice.getBoxOfficeResult().getDailyBoxOfficeList()) {
				System.out.print(d.getRank() + " : ");
				System.out.print(d.getMovieNm() + "(");
				System.out.println(d.getOpenDt() + ")");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
