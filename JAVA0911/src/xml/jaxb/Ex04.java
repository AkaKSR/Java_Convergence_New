package xml.jaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Ex04 {
	public static void main(String[] args) {
		try {
			// JAXBContext 객체 생성
			JAXBContext context = JAXBContext.newInstance(University.class);
			// Unmarshaller 객체 생성
			Unmarshaller um = context.createUnmarshaller();
			// 읽기
			University university = (University) um.unmarshal(new FileReader("university.xml"));
			System.out.println(university);
		} catch (JAXBException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
