package xml.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Ex03 {
	public static void main(String[] args) {
		StudentVO vo1 = new StudentVO(1, "한사람", "서울");
		StudentVO vo2 = new StudentVO(2, "두사람", "대구");
		StudentVO vo3 = new StudentVO(3, "세사람", "광주");
		StudentVO vo4 = new StudentVO(4, "네사람", "인천");
		
		vo1.setRegDate(new Date());
		vo2.setRegDate(new Date());
		vo3.setRegDate(new Date());
		vo4.setRegDate(new Date());
		
		List<StudentVO> list = new ArrayList<StudentVO>();
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		
		University university = new University();
		university.setName("공과대학");
		university.setAddress("대전");
		university.setStudents(list);
		
		try {
			// JAXB context 객체 생성
			JAXBContext context = JAXBContext.newInstance(University.class);
			
			// context를 이용하여 Marshaller객체 생성
			Marshaller m = context.createMarshaller();
			// XML을 이쁘게
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 출력
			m.marshal(university, System.out);
			m.marshal(university, new File("university.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
