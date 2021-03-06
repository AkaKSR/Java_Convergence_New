package kr.green.cf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import kr.green.vo.HanjaVO;

public class TodayHanja {
	public static void main(String[] args) {
		List<HanjaVO> list = readHanja();
		
		Set<Integer> todayHanja = new HashSet<>();
		Random rnd = new Random();
		while (todayHanja.size() < 4) {
			todayHanja.add(rnd.nextInt(1000));
		}
		System.out.println("호늘의 한자");
		for (int idx : todayHanja) {
			HanjaVO vo = list.get(idx);
			System.out.println(vo.getH() + "(" + vo.getK() + ") : " + vo.getM());
		}
	}

	private static List<HanjaVO> readHanja() { // 천자문을 읽어서 리스트로 리턴하는 메서드
		List<HanjaVO> list = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("chunja.txt"));
			while (sc.hasNextLine()) {
				String hanja[] = sc.nextLine().split("\\|");
				HanjaVO vo = new HanjaVO();
				vo.setIdx(hanja[0]);
				vo.setH(hanja[1]);
				vo.setK(hanja[2]);
				vo.setM(hanja[3]);
				list.add(vo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		return list;
	}
}
