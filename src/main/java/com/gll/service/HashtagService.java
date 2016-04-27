package com.gll.service;

import java.util.List;

import com.gll.model.Hashtag;

public interface HashtagService {
	public void post(Hashtag hashtag);

	public List<Hashtag> getAll();

	public Hashtag get(int annotationHashtagId);

	public void put(Hashtag hashtag);

	public void patch(Hashtag hashtag);

	public void delete(int annotationHashtagId);

	public Hashtag findByUpdatedBy(int updatedBy);
}
