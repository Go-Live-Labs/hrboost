package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.EmojiDao;
import com.gll.model.Emoji;

@Service("emojiService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class EmojiServiceImpl implements EmojiService {

	@Autowired
	private EmojiDao emojiDao;

	@Override
	public void post(Emoji emoji) {
		emojiDao.post(emoji);
		
	}

	@Override
	public List<Emoji> getAll() {
		return emojiDao.getAll();
	}

	@Override
	public Emoji get(int emojiId) {
		return emojiDao.get(emojiId);
	}

	@Override
	public void put(Emoji emoji) {
		emojiDao.put(emoji);
		
	}

	@Override
	public void patch(Emoji emoji) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int emojiId) {
		emojiDao.delete(emojiId);
		
	}

}
