package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.MovementDetEvent;

public interface MovementDetEventService {

	
	MovementDetEvent saveCargoDetecEvent(MovementDetEvent cargoDetecEvent);
	MovementDetEvent updateCargoDetecEvent(MovementDetEvent cargoDetecEvent);
	void deleteCargoDetecEvent(MovementDetEvent cargoDetecEvent);
	MovementDetEvent getCargoDetecEventById(Long id);
	List<MovementDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
