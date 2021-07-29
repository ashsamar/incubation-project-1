package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.CargoDetEvent;




public interface CargoDetecEventService {

	
	CargoDetEvent getCargoDetecEventById(Long id);
	List<CargoDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
