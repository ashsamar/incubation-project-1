package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.EmptyTruckDetEvent;
import com.hussain.location.repos.EmptyTruckDetEventRepository;


@Service
public class EmptyTruckDetEventServiceImpl implements EmptyTruckDetEventService {

	
	@Autowired
	private EmptyTruckDetEventRepository repos;
	
	
	@Override
	public EmptyTruckDetEvent saveCargoDetecEvent(EmptyTruckDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public EmptyTruckDetEvent updateCargoDetecEvent(EmptyTruckDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public void deleteCargoDetecEvent(EmptyTruckDetEvent cargoDetecEvent) {
		repos.delete(cargoDetecEvent);

	}

	@Override
	public EmptyTruckDetEvent getCargoDetecEventById(Long id) {
		EmptyTruckDetEvent object = new EmptyTruckDetEvent();
		object = repos.findById(id).get();
		return object;
	}

	@Override
	public List<EmptyTruckDetEvent> getAllCargoDetecEvents() {
		List<EmptyTruckDetEvent> allObjects = repos.findAll();
		return allObjects;
	}

	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		EmptyTruckDetEvent object = new EmptyTruckDetEvent();
        return	repos.getById(id).getImage();

	}

}
