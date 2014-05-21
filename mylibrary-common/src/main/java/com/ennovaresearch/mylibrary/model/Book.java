/**
 * 
 */
package com.ennovaresearch.mylibrary.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ennova
 *
 */
@XmlRootElement
public class Book {
	
	private String title;
	private String author;
	private String url;
	private String olid;
	private String coverName;
	
	/**
	 * 
	 */
	public Book() {}
	
	/**
	 * @param olid
	 * @param coverName
	 */
	public Book(String olid, String coverName) {
		this.olid = olid;
		this.coverName = coverName;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOlid() {
		return olid;
	}

	public void setOlid(String olid) {
		this.olid = olid;
	}

	public String getCoverName() {
		return coverName;
	}
	public void setCoverName(String coverName) {
		this.coverName = coverName;
	}
	
	
}
