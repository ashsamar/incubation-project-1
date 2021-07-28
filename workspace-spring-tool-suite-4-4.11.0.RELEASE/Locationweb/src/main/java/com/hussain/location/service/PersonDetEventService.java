package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.PersonDetEvent;

public interface PersonDetEventService {

	

	PersonDetEvent saveCargoDetecEvent(PersonDetEvent cargoDetecEvent);
	PersonDetEvent updateCargoDetecEvent(PersonDetEvent cargoDetecEvent);
	void deleteCargoDetecEvent(PersonDetEvent cargoDetecEvent);
	PersonDetEvent getCargoDetecEventById(Long id);
	List<PersonDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
