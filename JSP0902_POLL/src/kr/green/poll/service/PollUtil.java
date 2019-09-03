package kr.green.poll.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.green.poll.vo.PollVO;

public class PollUtil {
	// 데이터가 없이 특정 기능만을 가지는 클래스는 메서드들은 정적(static)메서드로 만든다.
	// 읽기
	public static List<PollVO> readPoll(InputStream is){
		List<PollVO> list = null;
		Gson gson = new Gson();
		InputStreamReader isr = new InputStreamReader(is);
		list = gson.fromJson(isr, new TypeToken<List<PollVO>>() {}.getType());
		return list;
	}
	// 저장하기
	public static void savePoll(String path, List<PollVO> list) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(path);
			Gson gson = new Gson();
			gson.toJson(list, pw);
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}



