package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.HashtagDao;
import com.gll.model.Hashtag;

@Service("hashtagService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class HashtagServiceImpl implements HashtagService {

	@Autowired
	private HashtagDao hashtagDao;

	@Override
	public void post(Hashtag hashtag) {
		hashtagDao.post(hashtag);
		
	}

	@Override
	public List<Hashtag> getAll() {
		return hashtagDao.getAll();
	}

	@Override
	public Hashtag get(int annotationHashtagId) {
		return hashtagDao.get(annotationHashtagId);
	}

	@Override
	public void put(Hashtag hashtag) {
		hashtagDao.put(hashtag);
		
	}

	@Override
	public void patch(Hashtag hashtag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int annotationHashtagId) {
		hashtagDao.delete(annotationHashtagId);
		
	}

	@Override
	public Hashtag findByUpdatedBy(int updatedBy) {
		return hashtagDao.findByUpdatedBy(updatedBy);
	}

	
}
