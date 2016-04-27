package com.gll.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gll.model.ParentDomain;

@Repository("parentDomainDao")
public class ParentDomainDaoImpl implements ParentDomainDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ParentDomain parentDomain) {
		sessionFactory.getCurrentSession().saveOrUpdate(parentDomain);
	}

	@Override
	public List<ParentDomain> displayAll() {
		return (List<ParentDomain>) sessionFactory.getCurrentSession().createCriteria(ParentDomain.class).list();
	}

	@Override
	public ParentDomain display(int parentDomainId) {
		return (ParentDomain) sessionFactory.getCurrentSession().get(ParentDomain.class, parentDomainId);
	}

	@Override
	public void update(ParentDomain parentDomain) {
		sessionFactory.getCurrentSession().saveOrUpdate(parentDomain);
		
	}

	@Override
	public void patch(ParentDomain parentDomain) {
	}

	@Override
	public void delete(int parentDomainId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ParentDomain WHERE parentDomainId = " + parentDomainId).executeUpdate();
	}

}
