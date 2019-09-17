package xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "University")
@XmlType(propOrder = { "name", "address", "students" })
public class University {

	List<StudentVO> students;

	private String name;

	private String address;

	@XmlElementWrapper(name = "Students")
	@XmlElement(name = "Student")
	public List<StudentVO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentVO> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "University [students=" + students + ", name=" + name + ", address=" + address + "]";
	}

}