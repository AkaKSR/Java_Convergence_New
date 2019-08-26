/*
 * Properties : <Object, Object> 맵이다. 프로그램 환경 설정에 많이 사용된다.
 */

package kr.green.list;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertiesEx1 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "admin");
		prop.put("password", "1234");
		prop.put("db", "oracle");
		
		System.out.println(prop.get("user"));
		System.out.println(prop.getProperty("password"));
		
		// 저장
		try {
			// prpperties 파일은 유니코드로 저장되어야 한다. 한글이 유니코드로 변경된다.
			// JDK에 들어있는 native2ascii.exe을 이용하여 변환을 해줘야 한다.
			prop.store(new PrintWriter("db.properties"), "DBMS 설정정보");
			prop.storeToXML(new FileOutputStream("db.xml"), "DBMS 설정정보");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
