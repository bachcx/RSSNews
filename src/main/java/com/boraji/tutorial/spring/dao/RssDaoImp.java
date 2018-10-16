package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.Rss;

@Repository
public class RssDaoImp implements RssDao{
	
	private static final Logger LOGGER = LogManager.getLogger(RssDaoImp.class.getName());
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Rss rss) {
		sessionFactory.getCurrentSession().save(rss);
	}

	@Override
	public List<Rss> list() {
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Rss> query = sessionFactory.getCurrentSession().createQuery("from Rss");
			return query.getResultList();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return null;
	}
	
	public Boolean exists (Rss rss) {
		String hql = "from Rss s where s.linkRss = :link";
		try {
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Rss> result = sessionFactory.getCurrentSession().createQuery(hql).setString("link", rss.getLinkRss()).list();
			return (result.size() > 0);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());	
		}
		return false;
	}

	@Override
	public Boolean remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Rss p = (Rss) session.load(Rss.class, new Integer(id));
		if(null != p){
			try {
				session.delete(p);
				return true;
			} catch (Exception e) {
				LOGGER.debug(e.getMessage());
				return false;
			}			
		}else {
			return false;
		}
	}
}
