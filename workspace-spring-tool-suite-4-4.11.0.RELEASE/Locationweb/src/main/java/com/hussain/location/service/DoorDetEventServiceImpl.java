package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.DoorDetEvent;
import com.hussain.location.repos.DoorDetEventRepository;


@Service
public class DoorDetEventServiceImpl implements DoorDetEventService {

	@Autowired
	DoorDetEventRepository repos;
	
	@Override
	public DoorDetEvent saveCargoDetecEvent(DoorDetEvent doorDetecEvent) {
		return repos.save(doorDetecEvent);
	}

	@Override
	public DoorDetEvent updateCargoDetecEvent(DoorDetEvent doorDetecEvent) {
		return repos.save(doorDetecEvent);
	}

	@Override
	public void deleteCargoDetecEvent(DoorDetEvent doorDetecEvent) {
		repos.delete(doorDetecEvent);

	}

	@Override
	public DoorDetEvent getCargoDetecEventById(Long id) {
		DoorDetEvent object = new DoorDetEvent();
		object = repos.findById(id).get();
		return object;
	}

	@Override
	public List<DoorDetEvent> getAllCargoDetecEvents() {
		List<DoorDetEvent> allObjects = repos.findAll();
		return allObjects;
	}
	
	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		CargoDetEvent object = new CargoDetEvent();
        return	repos.getById(id).getImage();

	
	}

}
