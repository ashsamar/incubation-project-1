package com.hussain.location.service;

import java.util.List;


import com.hussain.location.entities.Event;


public interface EventService {

	
	Event saveEvent(Event event);
	Event updateEvent(Event event);
	void deleteEvent(Event event);
	Event getEventById(Long id);
	List<Event> getAllEvents();
}
