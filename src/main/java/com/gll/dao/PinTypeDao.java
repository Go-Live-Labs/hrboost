package com.gll.dao;

import java.util.List;
import com.gll.model.PinType;

public interface PinTypeDao {
	public void post(PinType pinType);

	public List<PinType> getAll();

	public PinType get(int pinTypeId);

	public void put(PinType pinType);

	public void patch(PinType pinType);

	public void delete(int pinTypeId);
}
