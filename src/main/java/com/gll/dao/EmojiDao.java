package com.gll.dao;

import java.util.List;

import com.gll.model.Emoji;

public interface EmojiDao {
	public void post(Emoji emoji);

	public List<Emoji> getAll();

	public Emoji get(int emojiId);

	public void put(Emoji emoji);

	public void patch(Emoji emoji);

	public void delete(int emojiId);
}
