package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.EmptyTruckDetEvent;



public interface EmptyTruckDetEventService {
	
	EmptyTruckDetEvent getCargoDetecEventById(Long id);
	List<EmptyTruckDetEvent> getAllCargoDetecEvents();
	
	byte[] getCargoDetecEventImageById(Long id);
}
