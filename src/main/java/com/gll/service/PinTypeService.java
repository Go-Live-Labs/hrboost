package com.gll.service;

import java.util.List;

import com.gll.model.Emoji;
import com.gll.model.PinType;

public interface PinTypeService {
	public void post(PinType pinType);

	public List<PinType> getAll();

	public PinType get(int pinTypeId);

	public void put(PinType pinType);

	public void patch(PinType pinType);

	public void delete(int pinTypeId);
}
