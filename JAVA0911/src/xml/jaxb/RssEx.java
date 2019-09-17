package xml.jaxb;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class RssEx {
	public static void main(String[] args) {
		try {
			// JAXBContext 객체 생성
			JAXBContext context = JAXBContext.newInstance(Rss.class);
			// Unmarshaller 객체 생성
			Unmarshaller um = context.createUnmarshaller();
			// 읽기
			URL url = new URL("http://rss.ohmynews.com/rss/travel.xml");
			Rss rss = (Rss) um.unmarshal(url);
			for (Item item : rss.getChannel().getItem()) {
				System.out.println(item.getTitle());
			}
			System.out.println(rss);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
