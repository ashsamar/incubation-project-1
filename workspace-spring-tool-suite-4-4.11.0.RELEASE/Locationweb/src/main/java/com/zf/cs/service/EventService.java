package com.zf.cs.service;

import java.util.List;

import com.zf.cs.db.model.Event;


public interface EventService {

	
	Event saveEvent(Event event);
	Event updateEvent(Event event);
	void deleteEvent(Event event);
	Event getEventById(Long id);
	List<Event> getAllEvents();
}
