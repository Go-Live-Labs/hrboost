package com.gll.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.Emoji;

@Repository("emojiDao")
public class EmojiDaoImpl implements EmojiDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void post(Emoji emoji) {
		sessionFactory.getCurrentSession().saveOrUpdate(emoji);

	}

	@Override
	public List<Emoji> getAll() {
		return (List<Emoji>) sessionFactory.getCurrentSession().createCriteria(Emoji.class).list();
	}

	@Override
	public Emoji get(int emojiId) {
		return (Emoji) sessionFactory.getCurrentSession().get(Emoji.class, emojiId);
	}

	@Override
	public void put(Emoji emoji) {
		sessionFactory.getCurrentSession().saveOrUpdate(emoji);

	}

	@Override
	public void patch(Emoji emoji) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int emojiId) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Emoji WHERE emojiId = " + emojiId).executeUpdate();

	}

}