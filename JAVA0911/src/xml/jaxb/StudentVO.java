package xml.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Student")
@XmlType(propOrder = { "id", "name", "addr", "regDate"})
public class StudentVO {
	private int id;
	private String name;
	private String addr;
	private Date regDate;

	public StudentVO() {
	}

	public StudentVO(int id, String name, String addr) {
		this.id = id;
		this.name = name;
		this.addr = addr;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@XmlAttribute(name = "no")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", addr=" + addr + ", regDate=" + regDate + "]";
	}

}
