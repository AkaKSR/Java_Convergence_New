package kr.green.poll.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

import kr.green.poll.vo.PollVO;

/*
 * PollVO객체를 JSON으로 저장하고
 * JSON을 PollVO객체로 읽어오는 클래스
 */
public class JsonUtil {
	// JSON 파일을 읽어서 리턴해주는 메서드
	public static PollVO readJSON(InputStream is) {
		InputStreamReader isr = new InputStreamReader(is);
		Gson gson = new Gson();
		PollVO vo = gson.fromJson(isr, PollVO.class);
		return vo;
	}
	
	// PollVO 객체를 JSON파일로 저장해주는 메서드
	public static void saveJSON(String path, PollVO vo) {
		// 저장 경로와 저장할 VO를 인수로 받는다.
		PrintWriter pw = null;
		Gson gson = null;
		try {
			pw = new PrintWriter(path);
			gson = new Gson();
			gson.toJson(vo, pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
	
}
