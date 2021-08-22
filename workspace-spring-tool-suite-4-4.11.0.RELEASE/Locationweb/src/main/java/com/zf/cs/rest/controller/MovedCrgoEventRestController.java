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

import com.zf.cs.db.model.Event;
import com.zf.cs.db.model.MovedCargoDetEvent;
import com.zf.cs.db.model.MovementDetEvent;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.repository.MovedCargoDetEventRepository;
import com.zf.cs.repository.MovementDetEventRepository;
import com.zf.cs.rest.model.MovedCargoDetEventRest;
import com.zf.cs.rest.model.MovementDetEventRest;

@RestController
@RequestMapping("/movedcargo")
public class MovedCrgoEventRestController {

	
	@Autowired
	private MovedCargoDetEventRepository repos;
	
	@Autowired
	private EventRepository eventRepos;
	
	
	
	
	

	@GetMapping("/{id}")
	public Optional<MovedCargoDetEvent>  getOneMovedCargoDetEvent(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<MovedCargoDetEvent> getAllMovedCargoDetEvents()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public MovedCargoDetEvent addCargoDetEvent(@RequestBody MovedCargoDetEventRest event)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
		Date date = new Date();

		MovedCargoDetEvent movementdetevent = new MovedCargoDetEvent();
	//	CargoObject cargoObject = new CargoObject();
		
		
		
	
			movementdetevent.setReceiveddate(dateFormat.format(date));
		
		
		movementdetevent.setId(event.getId()) ;
		movementdetevent.setClientid(event.getClientid()) ;
		movementdetevent.setObjectid(event.getObjectid()) ;
		movementdetevent.setMovementeventtype(event.getMovementeventtype()) ;
		movementdetevent.setTimestamp(event.getTimestamp()) ;
		movementdetevent.setConfidence(event.getVolume().getConfidence()) ;
		movementdetevent.setX(event.getVolume().getX()) ;
		movementdetevent.setY(event.getVolume().getY()) ;
		movementdetevent.setZ(event.getVolume().getZ()) ;
		movementdetevent.setWidth(event.getVolume().getWidth()) ;
		movementdetevent.setDepth(event.getVolume().getDepth()) ;
		movementdetevent.setHeight(event.getVolume().getHeight()) ;
		
		movementdetevent.setNv_confidence(event.getNewVolume().getNv_confidence()) ;
		movementdetevent.setNv_x(event.getNewVolume().getNv_x()) ;
		movementdetevent.setNv_y(event.getNewVolume().getNv_y()) ;
		movementdetevent.setNv_z(event.getNewVolume().getNv_z()) ;
		movementdetevent.setNv_width(event.getNewVolume().getNv_width()) ;
		movementdetevent.setNv_depth(event.getNewVolume().getNv_depth()) ;
		movementdetevent.setNv_height(event.getNewVolume().getNv_height()) ;
		
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
	public MovedCargoDetEvent updateMovedCargoDetEvent(@RequestBody MovedCargoDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovedCargoDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
