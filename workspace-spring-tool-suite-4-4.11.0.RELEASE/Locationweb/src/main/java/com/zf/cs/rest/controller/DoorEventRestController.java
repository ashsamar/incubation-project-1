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

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.DoorDetEvent;
import com.zf.cs.db.model.Event;
import com.zf.cs.repository.DoorDetEventRepository;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.rest.model.AutomaticRecalEventRest;
import com.zf.cs.rest.model.DoorDetEventRest;

@RestController
@RequestMapping("/doordetection")
public class DoorEventRestController {

	
	
	@Autowired
	private DoorDetEventRepository repos;
	
	@Autowired
	private EventRepository eventRepos;
	
	
	
	
	
	
	@GetMapping("/{id}")
	public Optional<DoorDetEvent>  getDoorDetEventById(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<DoorDetEvent> getAllDoorDetEvent()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public DoorDetEvent addDoorDetEvent(@RequestBody DoorDetEventRest event)
	{
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
		Date date = new Date();

		DoorDetEvent doordetevent = new DoorDetEvent();
		
		
	
			doordetevent.setReceiveddate(dateFormat.format(date));
		
		doordetevent.setId(event.getId()) ;
		doordetevent.setClientid(event.getClientid()) ;
		doordetevent.setDooreventtype(event.getDooreventtype()) ;
		doordetevent.setTimestamp(event.getTimestamp());
		doordetevent.setDoor(event.getDoor()) ;
		doordetevent.setConfidence(event.getConfidence()) ;
		doordetevent.setImage(event.getImage()) ;
		doordetevent.setPointcloud(event.getPointcloud()) ;
		
		
		
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getDooreventtype());
	
			event1.setReceiveddate(dateFormat.format(date));
		
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());
		event1.setImage(event.getImage());
		event1.setPointcloud(event.getPointcloud());

		
		eventRepos.save(event1);
		
		
		return repos.save(doordetevent);
	}
	
	
	@PutMapping
	public DoorDetEvent updateDoorDetEvent(@RequestBody DoorDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDoorDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
