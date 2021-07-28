package com.hussain.location.service;

import java.util.List;

import com.hussain.location.entities.AutomaticRecalEvent;
import com.hussain.location.entities.CargoDetEvent;

public interface AutomaticRecalEventService {

	
	AutomaticRecalEvent saveCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent);
	AutomaticRecalEvent updateCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent);
	void deleteCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent);
	AutomaticRecalEvent getCargoDetecEventById(Long id);
	List<AutomaticRecalEvent> getAllCargoDetecEvents();
	
	
	byte[] getCargoDetecEventImageById(Long id);
}
