package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.MovementDetEvent;

public interface MovementDetEventService {

	
	MovementDetEvent saveCargoDetecEvent(MovementDetEvent cargoDetecEvent);
	MovementDetEvent updateCargoDetecEvent(MovementDetEvent cargoDetecEvent);
	void deleteCargoDetecEvent(MovementDetEvent cargoDetecEvent);
	MovementDetEvent getCargoDetecEventById(Long id);
	List<MovementDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
