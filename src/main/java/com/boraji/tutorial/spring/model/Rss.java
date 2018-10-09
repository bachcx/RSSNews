package com.boraji.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rss_tbl")
public class Rss {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nameRss")
	private String nameRss;
	
	@Column(name = "linkRss")
	private String linkRss;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNameRss() {
		return nameRss;
	}
	
	public void setNameRss(String nameRss) {
		this.nameRss = nameRss;
	}
	
	public String getLinkRss() {
		return linkRss;
	}
	
	public void setLinkRss(String linkRss) {
		this.linkRss = linkRss;
	}
	
}
