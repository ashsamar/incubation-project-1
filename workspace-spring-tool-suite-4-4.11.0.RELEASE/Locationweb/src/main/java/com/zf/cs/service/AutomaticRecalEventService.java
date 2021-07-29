package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.CargoDetEvent;

public interface AutomaticRecalEventService {

	
	AutomaticRecalEvent saveCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent);
	AutomaticRecalEvent updateCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent);
	void deleteCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent);
	AutomaticRecalEvent getCargoDetecEventById(Long id);
	List<AutomaticRecalEvent> getAllCargoDetecEvents();

}
