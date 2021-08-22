package com.zf.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.repository.CargoDetecEventRepository;


@Service
public class CargoDetecEventServiceImpl implements CargoDetecEventService {

	@Autowired
	CargoDetecEventRepository repos;




	@Override
	public CargoDetEvent getCargoDetecEventById(Long id) {
	
		return repos.findById(id).get();
	}

	@Override
	public List<CargoDetEvent> getAllCargoDetecEvents() {
		List<CargoDetEvent> allObjects = repos.findAll();
		return allObjects;
	}

	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		
        return	repos.getById(id).getImage();

	
	}


}
