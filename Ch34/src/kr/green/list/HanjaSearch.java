package kr.green.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HanjaSearch {
	public static void main(String[] args) {
		Map<String, HanjaVO> map = readHanja();
		Scanner sc = new Scanner(System.in);
		String hanja = "";
		
		while (!hanja.equals("0")) {
			System.out.print("찾고자하는 한자를 입력하세요.(0은 종료) : ");
			hanja = sc.nextLine();
			if (hanja.equals("0")) {
				continue;
			}
			if (map.containsKey(hanja)) {
				System.out.println("찾은 한자 : " + map.get(hanja));
			} else {
				System.out.println(hanja + "는 천자문에 없는 한자입니다.");
			}
		}
	}

	private static Map<String, HanjaVO> readHanja() {
		Map<String, HanjaVO> map = new TreeMap<String, HanjaVO>();

		try {
			Scanner sc = new Scanner(new File("chunja.txt"));
			while (sc.hasNextLine()) {
				String data[] = sc.nextLine().split("\\|"); // 1줄 읽어서 |을 구분하여 배열로 만들고
				HanjaVO vo = new HanjaVO(); // 객체 만들어 항목 채우고
				vo.setIndex(Integer.parseInt(data[0]));
				vo.setH(data[1]);
				vo.setK(data[3]);

				map.put(vo.getH(), vo);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
}
