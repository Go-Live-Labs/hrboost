package com.gll.dao;

import java.util.List;

import com.gll.model.ParentDomain;

public interface ParentDomainDao {
	public void save(ParentDomain parentDomain);
	public List<ParentDomain> displayAll();
	public ParentDomain display(int parentDomainId);
	public void update(ParentDomain parentDomain);
	public void patch(ParentDomain parentDomain);
	public void delete(int parentDomainId);
}
