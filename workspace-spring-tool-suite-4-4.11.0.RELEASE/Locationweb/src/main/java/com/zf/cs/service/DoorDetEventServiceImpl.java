package com.zf.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.DoorDetEvent;
import com.zf.cs.repository.DoorDetEventRepository;


@Service
public class DoorDetEventServiceImpl implements DoorDetEventService {

	@Autowired
	DoorDetEventRepository repos;
	


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
