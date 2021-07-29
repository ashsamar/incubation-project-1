package com.zf.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.repository.AutomaticRecalEventRepository;


@Service
public class AutomaticRecalEventServiceImpl implements AutomaticRecalEventService {
	
	@Autowired
	private AutomaticRecalEventRepository repos;
	

	@Override
	public AutomaticRecalEvent saveCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public AutomaticRecalEvent updateCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public void deleteCargoDetecEvent(AutomaticRecalEvent cargoDetecEvent) {
		repos.delete(cargoDetecEvent);

	}

	@Override
	public AutomaticRecalEvent getCargoDetecEventById(Long id) {
		AutomaticRecalEvent object = new AutomaticRecalEvent();
		object = repos.findById(id).get();
		return object;
	}

	@Override
	public List<AutomaticRecalEvent> getAllCargoDetecEvents() {
		List<AutomaticRecalEvent> allObjects = repos.findAll();
		return allObjects;
	}

	
}
