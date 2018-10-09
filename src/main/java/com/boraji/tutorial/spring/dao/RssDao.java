package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.tutorial.spring.model.Rss;

public interface RssDao {
	void save(Rss rss);
	List<Rss> list();
	Boolean exists(Rss rss);
}
