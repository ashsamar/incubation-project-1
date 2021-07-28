package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.location.entities.AutomaticRecalEvent;
import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.repos.AutomaticRecalEventRepository;


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

	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		AutomaticRecalEvent object = new AutomaticRecalEvent();
        return	repos.getById(id).getImage();
	}

}
