package com.gll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.Hashtag;

@Repository("hashtagDao")
public class HashtagDaoImpl implements HashtagDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void post(Hashtag hashtag) {
		sessionFactory.getCurrentSession().saveOrUpdate(hashtag);

	}

	@Override
	public List<Hashtag> getAll() {
		return (List<Hashtag>) sessionFactory.getCurrentSession().createCriteria(Hashtag.class).list();
	}

	@Override
	public Hashtag get(int annotationHashtagId) {
		return (Hashtag) sessionFactory.getCurrentSession().get(Hashtag.class, annotationHashtagId);
	}

	@Override
	public void put(Hashtag hashtag) {
		sessionFactory.getCurrentSession().saveOrUpdate(hashtag);

	}

	@Override
	public void patch(Hashtag hashtag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int annotationHashtagId) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Hashtag WHERE annotationHashtagId = " + annotationHashtagId).executeUpdate();

	}

	@Override
	public Hashtag findByUpdatedBy(int updatedBy) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Hashtag WHERE updatedBy =:updatedBy");
		query.setInteger("updatedBy", updatedBy);
		return (Hashtag) query.uniqueResult();
	}

}