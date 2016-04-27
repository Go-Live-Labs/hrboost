package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.ParentDomainDao;
import com.gll.model.ParentDomain;

@Service("parentDomainService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class ParentDoaminServiceImpl implements ParentDomainService {

	@Autowired
	private ParentDomainDao parentDomainDao;

	@Override
	public void save(ParentDomain parentDomain) {
		parentDomainDao.save(parentDomain);

	}

	@Override
	public List<ParentDomain> displayAll() {
		return parentDomainDao.displayAll();
	}

	@Override
	public ParentDomain display(int parentDomainId) {
		return parentDomainDao.display(parentDomainId);
	}

	@Override
	public void update(ParentDomain parentDomain) {
		parentDomainDao.update(parentDomain);

	}

	@Override
	public void patch(ParentDomain parentDomain) {

	}

	@Override
	public void delete(int parentDomainId) {
		parentDomainDao.delete(parentDomainId);

	}

}
