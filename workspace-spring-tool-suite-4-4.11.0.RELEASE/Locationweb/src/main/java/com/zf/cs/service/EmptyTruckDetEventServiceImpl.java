package com.zf.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.EmptyTruckDetEvent;
import com.zf.cs.repository.EmptyTruckDetEventRepository;


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
