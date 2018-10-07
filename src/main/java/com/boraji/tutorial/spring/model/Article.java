package com.boraji.tutorial.spring.model;

public class Article {
	private boolean videoFlag;
	private String title;
	private String pubDate;
	private String link;
	private String contentEncode;
	private String mediaLink;
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

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getMediaLink() {
		return mediaLink;
	}

	public void setMediaLink(String mediaLink) {
		this.mediaLink = mediaLink;
	}

	public boolean isVideoFlag() {
		return videoFlag;
	}

	public void setVideoFlag(boolean videoFlag) {
		this.videoFlag = videoFlag;
	}
	
}
