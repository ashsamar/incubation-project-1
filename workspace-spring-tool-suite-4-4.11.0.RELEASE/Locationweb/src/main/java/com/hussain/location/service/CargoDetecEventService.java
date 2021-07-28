package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.CargoDetEvent;




public interface CargoDetecEventService {

	
	CargoDetEvent saveCargoDetecEvent(CargoDetEvent cargoDetecEvent);
	CargoDetEvent updateCargoDetecEvent(CargoDetEvent cargoDetecEvent);
	void deleteCargoDetecEvent(CargoDetEvent cargoDetecEvent);
	CargoDetEvent getCargoDetecEventById(Long id);
	List<CargoDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
