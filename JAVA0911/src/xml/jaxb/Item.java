package xml.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
// @XmlType(propOrder = { "author", "category", "title", "link", "pubDate", "description" })
public class Item {
	private String author;
	private String category;
	private String title;
	private String link;
	private Date pubDate;
	private String description;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

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

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [author=" + author + ", category=" + category + ", title=" + title + ", link=" + link
				+ ", pubDate=" + pubDate + ", description=" + description + "]";
	}

}
