package kr.green.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

public class JsonEx01 {
	public static void main(String[] args) {
		String data = "[11,22,33,44,55,66]";

		// Gson을 사용하지 않고 위의 데이터를 정수 배열로 사용하겠다.
		System.out.println("[Without Gson]");
		int ar[] = new int[6];
		String data2 = data.substring(1, data.length() - 1);
		System.out.println(data2);
		String t[] = data2.split(",");
		for (int i = 0; i < t.length; i++) {
			ar[i] = Integer.parseInt(t[i]);
		}
		System.out.println(Arrays.toString(ar));

		System.out.println();

		// Gson을 사용하는 방법
		System.out.println("[With Gson]");
		Gson gson = new Gson();

		// 읽을때는 fromJson(자료, 타입)
		int ar2[] = gson.fromJson(data, int[].class);
		System.out.println("fromJson: " + Arrays.toString(ar2));

		// 저장할때는 to(객체)
		String data3 = gson.toJson(ar2);
		System.out.println("toJson: " + data3);

		System.out.println();
		
		// Gson을 이용하여 json파일을 저장하는 방법
		try {
			FileWriter fw = new FileWriter("ar.json");
			gson.toJson(ar2, fw);
			fw.close();
		} catch (JsonIOException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// json데이터를 List로 읽기
		System.out.println("[json -> List]");
		List<Integer> list = gson.fromJson(data3, new TypeToken<List<Integer>>() {}.getType());
		System.out.println(list);
		
		// Gson을 이용하여 json파일을 읽어오는 방법
	}
}



















