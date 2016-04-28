package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.PinTypeDao;
import com.gll.model.PinType;

@Service("pinTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class PinTypeServiceImpl implements PinTypeService {

	@Autowired
	private PinTypeDao pinTypeDao;

	@Override
	public void post(PinType pinType) {
		pinTypeDao.post(pinType);
		
	}

	@Override
	public List<PinType> getAll() {
		return pinTypeDao.getAll();
	}

	@Override
	public PinType get(int pinTypeId) {
		return pinTypeDao.get(pinTypeId);
	}

	@Override
	public void put(PinType pinType) {
		pinTypeDao.put(pinType);
		
	}

	@Override
	public void patch(PinType pinType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int pinTypeId) {
		pinTypeDao.delete(pinTypeId);
		
	}

}
