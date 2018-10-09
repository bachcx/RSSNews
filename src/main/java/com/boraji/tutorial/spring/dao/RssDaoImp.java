package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.Rss;

@Repository
public class RssDaoImp implements RssDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Rss rss) {
		sessionFactory.getCurrentSession().save(rss);
	}

	@Override
	public List<Rss> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<Rss> query = sessionFactory.getCurrentSession().createQuery("from Rss");
		return query.getResultList();
	}
	
	public Boolean exists (Rss rss) {
//		String hql = "from Rss s where s.linkRss =  '" + rss.getLinkRss() + "'";
		String hql = "from Rss s where s.linkRss = :link";
		@SuppressWarnings({ "unchecked", "deprecation"})
		List<Rss> result = sessionFactory.getCurrentSession().createQuery(hql).setString("link", rss.getLinkRss()).list();
		return (result.size() > 0);
	}
}
