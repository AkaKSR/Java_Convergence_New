package xml.jaxb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	@Override
	public Date unmarshal(String v) throws Exception {
		// String을 Date 타입으로 변환해준다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) hh시 mm분 ss.SSS초");
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		// Date 타입을 String으로 변환해준다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) hh시 mm분 ss.SSS초");
		return sdf.format(v);
	}

}
