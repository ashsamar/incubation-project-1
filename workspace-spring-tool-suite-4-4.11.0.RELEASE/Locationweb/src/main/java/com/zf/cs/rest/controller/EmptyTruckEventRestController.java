package com.zf.cs.rest.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zf.cs.db.model.DoorDetEvent;
import com.zf.cs.db.model.EmptyTruckDetEvent;
import com.zf.cs.db.model.Event;
import com.zf.cs.repository.EmptyTruckDetEventRepository;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.rest.model.EmptyTruckDetEventRest;

@RestController
@RequestMapping("/emptytruck")
public class EmptyTruckEventRestController {

	
	@Autowired
	private EmptyTruckDetEventRepository repos;
	
	@Autowired
	private EventRepository eventRepos;

	
	@GetMapping("/{id}")
	public Optional<EmptyTruckDetEvent>  getEmptyTruckDetEventById(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<EmptyTruckDetEvent> getAllEmptyTruckDetEvent()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public EmptyTruckDetEvent addEmptyTruckDetEvent(@RequestBody EmptyTruckDetEventRest event)
	{
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
		Date date = new Date();

		EmptyTruckDetEvent emptytruckevent = new EmptyTruckDetEvent();
		
		
		
			emptytruckevent.setReceiveddate(dateFormat.format(date));
		
		emptytruckevent.setId(event.getId()) ;
		emptytruckevent.setClientid(event.getClientid()) ;
		emptytruckevent.setEmptytruckdeteventtype(event.getEmptytruckdeteventtype()) ;
		emptytruckevent.setTimestamp(event.getTimestamp());
		emptytruckevent.setConfidence(event.getConfidence()) ;
		emptytruckevent.setImage(event.getImage()) ;
		emptytruckevent.setPointcloud(event.getPointcloud()) ;
		
		
		
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getEmptytruckdeteventtype());
		
			event1.setReceiveddate(dateFormat.format(date));
		
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());
		event1.setImage(event.getImage());
		event1.setPointcloud(event.getPointcloud());

		
		eventRepos.save(event1);
		
		
		return repos.save(emptytruckevent);
	}
	
	
	@PutMapping
	public EmptyTruckDetEvent updateEmptyTruckDetEvent(@RequestBody EmptyTruckDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmptyTruckDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
