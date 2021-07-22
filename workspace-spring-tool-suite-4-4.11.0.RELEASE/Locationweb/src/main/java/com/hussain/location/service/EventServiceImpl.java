package com.hussain.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hussain.location.entities.Event;
	
import com.hussain.location.repos.EventRepository;


@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository repos;
	
	@Override
	public Event saveEvent(Event event) {
		
		return repos.save(event);
	}

	@Override
	public Event updateEvent(Event event) {
		
		return repos.save(event);
	}

	@Override
	public void deleteEvent(Event event) {
		
		repos.delete(event);
	}

	@Override
	public Event getEventById(Long id) {
	
		Event event = new Event();
		event = repos.findById(id).get();
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> allEvents = repos.findAll();
		return allEvents;
	}

}
