package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.model.Rss;

public interface RssService {
	void save(Rss rss);
	List<Rss> list();
	Boolean exists(Rss rss);
}
