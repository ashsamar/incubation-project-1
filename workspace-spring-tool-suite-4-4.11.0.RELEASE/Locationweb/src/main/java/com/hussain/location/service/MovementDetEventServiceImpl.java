package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.MovementDetEvent;
import com.hussain.location.repos.MovementDetEventRepository;

@Service
public class MovementDetEventServiceImpl implements MovementDetEventService {

	@Autowired
	MovementDetEventRepository repos;
	
	@Override
	public MovementDetEvent saveCargoDetecEvent(MovementDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public MovementDetEvent updateCargoDetecEvent(MovementDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public void deleteCargoDetecEvent(MovementDetEvent cargoDetecEvent) {
		repos.delete(cargoDetecEvent);;;

	}

	@Override
	public MovementDetEvent getCargoDetecEventById(Long id) {
		MovementDetEvent object = new MovementDetEvent();
		object = repos.findById(id).get();
		return object;
	}

	@Override
	public List<MovementDetEvent> getAllCargoDetecEvents() {
		List<MovementDetEvent> allObjects = repos.findAll();
		return allObjects;
	}

	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		CargoDetEvent object = new CargoDetEvent();
        return	repos.getById(id).getImage();

	
	}
	
}
