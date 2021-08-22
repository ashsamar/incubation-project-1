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
import com.zf.cs.db.model.Event;
import com.zf.cs.db.model.NonOperatingDetEvent;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.repository.NonOperatingDetEventRepsitory;
import com.zf.cs.rest.model.AutomaticRecalEventRest;
import com.zf.cs.rest.model.NonOperatingDetEventRest;

@RestController
@RequestMapping("/nonoperating")
public class NonOperatingEventRestController {

	
	@Autowired
	private NonOperatingDetEventRepsitory repos;
	
	@Autowired
	private EventRepository eventRepos;
	
	@GetMapping("/{id}")
	public Optional<NonOperatingDetEvent>  getOneNonOperatingDetEvent(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<NonOperatingDetEvent> getAllNonOperatingDetEvents()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public NonOperatingDetEvent addNonOperatingDetEvent(@RequestBody NonOperatingDetEventRest event)
	{
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
		Date date = new Date();

		NonOperatingDetEvent nonopratingdetevent = new NonOperatingDetEvent();
		
		
		
			nonopratingdetevent.setReceiveddate(dateFormat.format(date));
		
		nonopratingdetevent.setId(event.getId()) ;
		nonopratingdetevent.setClientid(event.getClientid()) ;
		nonopratingdetevent.setNonoperatingdeteventtype(event.getNonoperatingdeteventtype()) ;
		nonopratingdetevent.setTimestamp(event.getTimestamp()) ;
		nonopratingdetevent.setErrorcode(event.getErrorcode()) ;
		nonopratingdetevent.setErrormsg(event.getErrormsg()) ;
		
		
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getNonoperatingdeteventtype());
		
			event1.setReceiveddate(dateFormat.format(date));
	
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());

		
		eventRepos.save(event1);
		
		
		return repos.save(nonopratingdetevent);
	}
	
	
	@PutMapping
	public NonOperatingDetEvent updateNonOperatingDetEvent(@RequestBody NonOperatingDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteNonOperatingDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
