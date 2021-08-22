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

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.Event;
import com.zf.cs.db.model.MovementDetEvent;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.repository.MovementDetEventRepository;
import com.zf.cs.rest.model.CargoDetEventRest;
import com.zf.cs.rest.model.CargoObject;
import com.zf.cs.rest.model.MovementDetEventRest;

@RestController
@RequestMapping("/movementdetection")
public class MovementEventRestController {

	
	@Autowired
	private MovementDetEventRepository repos;
	
	@Autowired
	private EventRepository eventRepos;
	
	
	
	
	@GetMapping("/{id}")
	public Optional<MovementDetEvent>  getOneMovementDetEvent(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<MovementDetEvent> getAllMovementDetEvents()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public MovementDetEvent addCargoDetEvent(@RequestBody MovementDetEventRest event)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
		Date date = new Date();

		MovementDetEvent movementdetevent = new MovementDetEvent();
	//	CargoObject cargoObject = new CargoObject();
		
		
		
		
			movementdetevent.setReceiveddate(dateFormat.format(date));
		
		
		
		movementdetevent.setId(event.getId()) ;
		movementdetevent.setClientid(event.getClientid()) ;
		movementdetevent.setEachmovementeventid(event.getMovementVolume().getEachmovementeventid()) ;
		movementdetevent.setMovementeventtype(event.getMovementeventtype()) ;
		movementdetevent.setTimestamp(event.getTimestamp()) ;
		movementdetevent.setConfidence(event.getMovementVolume().getConfidence()) ;
		movementdetevent.setX(event.getMovementVolume().getX()) ;
		movementdetevent.setY(event.getMovementVolume().getY()) ;
		movementdetevent.setZ(event.getMovementVolume().getZ()) ;
		movementdetevent.setWidth(event.getMovementVolume().getWidth()) ;
		movementdetevent.setDepth(event.getMovementVolume().getDepth()) ;
		movementdetevent.setHeight(event.getMovementVolume().getHeight()) ;
		
		movementdetevent.setImage(event.getImage()) ;
		movementdetevent.setPointcloud(event.getPointcloud()) ;
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getMovementeventtype());
	
			event1.setReceiveddate(dateFormat.format(date));
		
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());
		event1.setImage(event.getImage());
		event1.setPointcloud(event.getPointcloud());
		
		eventRepos.save(event1);
		
		// TODO: transform request Objects to database model
	//	return repos.saveCargoEvent(event);
		return repos.save(movementdetevent);
	}
	
	
	@PutMapping
	public MovementDetEvent updateMovementDetEvent(@RequestBody MovementDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovementDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
