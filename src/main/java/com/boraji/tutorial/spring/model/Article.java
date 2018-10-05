package com.boraji.tutorial.spring.model;

public class Article {
	private String title;
	private String pubDate;
	private String link;
	private String contentEncode;
	private String imgLink;
	private String shortContent;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getContentEncode() {
		return contentEncode;
	}
	
	public void setContentEncode(String contentEncode) {
		this.contentEncode = contentEncode;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	
}
