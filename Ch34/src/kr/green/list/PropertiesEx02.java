package kr.green.list;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesEx02 {
	public static void main(String[] args) {
		Properties properties = new Properties();
		
		try {
			properties.load(new FileReader("db.properties"));
			System.out.println(properties.getProperty("user"));
			System.out.println(properties.getProperty("password"));
			System.out.println(properties.getProperty("db"));
			System.out.println();
			properties.loadFromXML(new FileInputStream("db.xml"));
			System.out.println(properties.getProperty("user"));
			System.out.println(properties.getProperty("password"));
			System.out.println(properties.getProperty("db"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
