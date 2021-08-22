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
import com.zf.cs.db.model.Event;
import com.zf.cs.db.model.PersonDetEvent;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.repository.PersonDetEventRepository;
import com.zf.cs.rest.model.PersonConfig;
import com.zf.cs.rest.model.PersonDetEventRest;

@RestController
@RequestMapping("/persondetection")
public class PersonEventRest {
	
	
    @Autowired
	private PersonDetEventRepository repos;
    
	@Autowired
    private EventRepository eventRepos;
	
	
	
	@GetMapping("/{id}")
	public Optional<PersonDetEvent>  getPersonDetEventById(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<PersonDetEvent> getAllPersonDetEvent()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public PersonDetEvent addPersonDetEvent(@RequestBody PersonDetEventRest event)
	{
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
		Date date = new Date();

		PersonDetEvent persondetevent = new PersonDetEvent();

		
		
		
			persondetevent.setReceiveddate(dateFormat.format(date));
		
		persondetevent.setId(event.getId()) ;
		persondetevent.setClientid(event.getClientid()) ;
		persondetevent.setPersondeteventtype(event.getPersondeteventtype()) ;
		persondetevent.setTimestamp(event.getTimestamp());
		persondetevent.setHeight(event.getPersonConfig().getHeight()) ;
		persondetevent.setConfidence(event.getPersonConfig().getConfidence()) ;
		persondetevent.setX(event.getPersonConfig().getX());
		persondetevent.setY(event.getPersonConfig().getY());
		persondetevent.setZ(event.getPersonConfig().getZ());
		persondetevent.setImage(event.getImage()) ;
		persondetevent.setPointcloud(event.getPointcloud()) ;
		
		
		
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getPersondeteventtype());
	
			event1.setReceiveddate(dateFormat.format(date));
		
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());
		event1.setImage(event.getImage());
		event1.setPointcloud(event.getPointcloud());

		
		eventRepos.save(event1);
		
		
		return repos.save(persondetevent);
	}
	
	
	@PutMapping
	public PersonDetEvent updatePersonDetEvent(@RequestBody PersonDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deletePersonDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
