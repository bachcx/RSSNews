package com.boraji.tutorial.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.dao.RssDao;
import com.boraji.tutorial.spring.model.Rss;

@Service
public class RssServiceImp implements RssService {
	
	@Autowired
	private RssDao rssDao;
	
	@Transactional
	public void save(Rss rss) {
		rssDao.save(rss);
		
	}

	@Transactional(readOnly = true)
	public List<Rss> list() {
		return rssDao.list();
	}

	@Transactional(readOnly = true)
	public Boolean exists(Rss rss) {
		return rssDao.exists(rss);
	}

}
