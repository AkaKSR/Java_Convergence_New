package kr.green.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.green.vo.HanjaVO;

public class JsonEx02 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		FileReader fr;

		try {
			fr = new FileReader("json/chunja.json");
			List<HanjaVO> list = gson.fromJson(fr, new TypeToken<List<HanjaVO>>() {
			}.getType());
			System.out.println(list.size() + "개 읽음.");
			for (HanjaVO vo : list) {
				System.out.println(vo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
