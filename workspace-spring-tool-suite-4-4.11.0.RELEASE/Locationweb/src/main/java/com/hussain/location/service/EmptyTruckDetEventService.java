package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.EmptyTruckDetEvent;



public interface EmptyTruckDetEventService {
	
	EmptyTruckDetEvent saveCargoDetecEvent(EmptyTruckDetEvent cargoDetecEvent);
	EmptyTruckDetEvent updateCargoDetecEvent(EmptyTruckDetEvent cargoDetecEvent);
	void deleteCargoDetecEvent(EmptyTruckDetEvent cargoDetecEvent);
	EmptyTruckDetEvent getCargoDetecEventById(Long id);
	List<EmptyTruckDetEvent> getAllCargoDetecEvents();
	
	byte[] getCargoDetecEventImageById(Long id);
}
