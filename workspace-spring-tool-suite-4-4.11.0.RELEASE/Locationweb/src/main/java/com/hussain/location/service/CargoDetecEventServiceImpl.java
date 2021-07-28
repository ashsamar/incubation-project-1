package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.location.entities.CargoDetEvent;

import com.hussain.location.repos.CargoDetecEventRepository;


@Service
public class CargoDetecEventServiceImpl implements CargoDetecEventService {

	@Autowired
	CargoDetecEventRepository repos;



	@Override
	public CargoDetEvent saveCargoDetecEvent(CargoDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public CargoDetEvent updateCargoDetecEvent(CargoDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public void deleteCargoDetecEvent(CargoDetEvent cargoDetecEvent) {
		repos.delete(cargoDetecEvent);
		
	}

	@Override
	public CargoDetEvent getCargoDetecEventById(Long id) {
		CargoDetEvent object = new CargoDetEvent();
		object = repos.findById(id).get();
		return object;
	}

	@Override
	public List<CargoDetEvent> getAllCargoDetecEvents() {
		List<CargoDetEvent> allObjects = repos.findAll();
		return allObjects;
	}

	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		CargoDetEvent object = new CargoDetEvent();
        return	repos.getById(id).getImage();

	
	}


}
