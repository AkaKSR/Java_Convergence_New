package xml.jaxb;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "channel")
// @XmlType(propOrder = { "title", "link", "language", "description", "copyright", "lastBuildDate", "item" })
public class Channel {
	private String title;
	private String link;
	private String language;
	private String description;
	private String copyright;
	private Date lastBuildDate;
	private List<Item> item;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Channel [title=" + title + ", link=" + link + ", language=" + language + ", description=" + description
				+ ", copyright=" + copyright + ", lastBuildDate=" + lastBuildDate + ", item=" + item + "]";
	}

}
