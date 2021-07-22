package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.DoorDetEvent;

public interface DoorDetEventService {
	
	DoorDetEvent saveCargoDetecEvent(DoorDetEvent doorDetecEvent);
	DoorDetEvent updateCargoDetecEvent(DoorDetEvent doorDetecEvent);
	void deleteCargoDetecEvent(DoorDetEvent doorDetecEvent);
	DoorDetEvent getCargoDetecEventById(Long id);
	List<DoorDetEvent> getAllCargoDetecEvents();

}
