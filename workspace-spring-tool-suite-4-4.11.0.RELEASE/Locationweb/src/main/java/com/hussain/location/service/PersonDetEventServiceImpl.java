package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.PersonDetEvent;
import com.hussain.location.repos.PersonDetEventRepository;


@Service
public class PersonDetEventServiceImpl implements PersonDetEventService {
	
	
	
	@Autowired
	PersonDetEventRepository repos;

	@Override
	public PersonDetEvent saveCargoDetecEvent(PersonDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public PersonDetEvent updateCargoDetecEvent(PersonDetEvent cargoDetecEvent) {
		return repos.save(cargoDetecEvent);
	}

	@Override
	public void deleteCargoDetecEvent(PersonDetEvent cargoDetecEvent) {
		repos.delete(cargoDetecEvent);

	}

	@Override
	public PersonDetEvent getCargoDetecEventById(Long id) {
		PersonDetEvent object = new PersonDetEvent();
		object = repos.findById(id).get();
		return object;
	}

	@Override
	public List<PersonDetEvent> getAllCargoDetecEvents() {
		List<PersonDetEvent> allObjects = repos.findAll();
		return allObjects;
	}

	@Override
	public byte[] getCargoDetecEventImageById(Long id) {
		PersonDetEvent object = new PersonDetEvent();
        return	repos.getById(id).getImage();
	}

}
