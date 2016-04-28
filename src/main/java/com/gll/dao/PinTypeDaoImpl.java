package com.gll.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.PinType;

@Repository("pinTypeDao")
public class PinTypeDaoImpl implements PinTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void post(PinType pinType) {
		sessionFactory.getCurrentSession().saveOrUpdate(pinType);

	}

	@Override
	public List<PinType> getAll() {
		return (List<PinType>) sessionFactory.getCurrentSession().createCriteria(PinType.class).list();
	}

	@Override
	public PinType get(int pinTypeId) {
		return (PinType) sessionFactory.getCurrentSession().get(PinType.class, pinTypeId);
	}

	@Override
	public void put(PinType pinType) {
		sessionFactory.getCurrentSession().saveOrUpdate(pinType);

	}

	@Override
	public void patch(PinType pinType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int pinTypeId) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM PinType WHERE pinTypeId = " + pinTypeId).executeUpdate();

	}

}