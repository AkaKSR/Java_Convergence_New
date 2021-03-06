package kr.green.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import kr.green.vo.ScoreVO;

public class ScoreEx {
	public static void main(String[] args) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		// 텍스트 파일을 읽어서 list에 넣고
		try {
			Scanner sc = new Scanner(new File("score.txt"));
			while (sc.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				if (st.hasMoreTokens()) {
					ScoreVO vo = new ScoreVO();
					vo.setName(st.nextToken());
					vo.setKor(Integer.parseInt(st.nextToken()));
					vo.setEng(Integer.parseInt(st.nextToken()));
					vo.setMat(Integer.parseInt(st.nextToken()));
					vo.setEdps(Integer.parseInt(st.nextToken()));
					list.add(vo);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 석차 구하고
		for (int i = 0; i < list.size()-1; i++) { // n-1회
			for (int j = i+1; j < list.size(); j++) { // i+1 ~ n까지
				if (list.get(i).getSum() > list.get(j).getSum()) {
					list.get(j).setRank(list.get(j).getRank()+1);
				} else if (list.get(i).getSum() < list.get(j).getSum()) {
					list.get(i).setRank(list.get(i).getRank()+1);
				}
			}
		}
		// 석차까지 있는 데이터를 파일로 출력한다.
		try(FileWriter fw = new FileWriter("result.txt")) {
			for (ScoreVO vo : list) {
				fw.append(vo.toString() + "\n");
				fw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("처리 완료.");
	}
}
