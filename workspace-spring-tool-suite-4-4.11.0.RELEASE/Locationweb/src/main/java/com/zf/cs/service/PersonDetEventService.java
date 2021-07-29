package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.PersonDetEvent;

public interface PersonDetEventService {

	

	PersonDetEvent saveCargoDetecEvent(PersonDetEvent cargoDetecEvent);
	PersonDetEvent updateCargoDetecEvent(PersonDetEvent cargoDetecEvent);
	void deleteCargoDetecEvent(PersonDetEvent cargoDetecEvent);
	PersonDetEvent getCargoDetecEventById(Long id);
	List<PersonDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
