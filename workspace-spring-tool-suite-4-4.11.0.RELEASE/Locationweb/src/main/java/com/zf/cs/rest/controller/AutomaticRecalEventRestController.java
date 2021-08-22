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
import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.Event;
import com.zf.cs.repository.AutomaticRecalEventRepository;
import com.zf.cs.repository.CargoDetecEventRepository;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.rest.model.AutomaticRecalEventRest;

@RestController
@RequestMapping("/automaticRecalEvents")
public class AutomaticRecalEventRestController {
	
	
	
	
	@Autowired
	private AutomaticRecalEventRepository repos;
	
	@Autowired
	private EventRepository eventRepos;
	
	
	@GetMapping("/{id}")
	public Optional<AutomaticRecalEvent>  getOneAutomaticRecalEvent(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<AutomaticRecalEvent> getAllAutomaticRecalEvents()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public AutomaticRecalEvent addAutomaticRecalEvent(@RequestBody AutomaticRecalEventRest event)
	{
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd : HH:mm:ss");
		Date date = new Date();

		AutomaticRecalEvent automaticrecalevent = new AutomaticRecalEvent();
		
		
	
			automaticrecalevent.setReceiveddate(dateFormat.format(date));
		
		automaticrecalevent.setId(event.getId()) ;
		automaticrecalevent.setClientid(event.getClientid()) ;
		automaticrecalevent.setAutomaticrecaleventtype(event.getAutomaticrecaleventtype()) ;
		automaticrecalevent.setTimestamp(event.getTimestamp()) ;
		automaticrecalevent.setAnglediff(event.getAnglediff()) ;
		automaticrecalevent.setStatus(event.getStatus()) ;
		
		
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getAutomaticrecaleventtype());
		
			event1.setReceiveddate(dateFormat.format(date));
		
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());

		
		eventRepos.save(event1);
		
		
		return repos.save(automaticrecalevent);
	}
	
	
	@PutMapping
	public AutomaticRecalEvent updateAutomaticRecalEvent(@RequestBody AutomaticRecalEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAutomaticRecalEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}

}
