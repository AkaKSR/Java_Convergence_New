package xml.jaxb;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/*
 * Mashalling : Java 객체를 XML로 만드는 것
 * UnMarshalling : XML을 Java 객체로 만드는 것
 */
public class Ex01 {
	public static void main(String[] args) {
		StudentVO vo = new StudentVO(1, "한사람", "서울");
		vo.setRegDate(new Date());
		
		try {
			// JAXB context 객체 생성
			JAXBContext context = JAXBContext.newInstance(StudentVO.class);
			
			// context를 이용하여 Marshaller객체 생성
			Marshaller m = context.createMarshaller();
			// XML을 이쁘게
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 출력
			m.marshal(vo, System.out);
			m.marshal(vo, new File("student.xml"));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
