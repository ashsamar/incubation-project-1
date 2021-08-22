package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.DoorDetEvent;

public interface DoorDetEventService {
	
	
	DoorDetEvent getCargoDetecEventById(Long id);
	List<DoorDetEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);

}
