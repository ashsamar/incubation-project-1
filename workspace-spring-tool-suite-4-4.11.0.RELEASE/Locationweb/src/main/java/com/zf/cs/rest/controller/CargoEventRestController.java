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
import com.zf.cs.db.model.Client;
import com.zf.cs.db.model.Event;
import com.zf.cs.repository.CargoDetecEventRepository;
import com.zf.cs.repository.ClientRepository;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.rest.model.CargoDetEventRest;
import com.zf.cs.rest.model.CargoObject;

@RestController
@RequestMapping("/cargoEvents")
public class CargoEventRestController {

	
	@Autowired
	private CargoDetecEventRepository repos;
	
	@Autowired
	private EventRepository eventRepos;
	
	
	@GetMapping("/{id}")
	public Optional<CargoDetEvent>  getOneCargoDetEventEvent(@PathVariable("id") Long  id)
	{
	     return repos.findById(id);
		 
	}
	
	
	
	@GetMapping
	public List<CargoDetEvent> getAllCargoDetEventEvents()
	{
		
		return repos.findAll();
		
	}
	
	@PostMapping
	public CargoDetEvent addCargoDetEvent(@RequestBody CargoDetEventRest event)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd : HH:mm:ss");
		Date date = new Date();

		CargoDetEvent cargodetevent = new CargoDetEvent();
		CargoObject cargoObject = new CargoObject();
		
			cargodetevent.setReceiveddate(dateFormat.format(date));
		
		
		cargodetevent.setId(event.getId()) ;
		cargodetevent.setClientid(event.getClientid()) ;
		cargodetevent.setEachcargoeventid(event.getCargoObject().getEachcargoeventid()) ;
		cargodetevent.setCargoeventtype(event.getCargoeventtype()) ;
		cargodetevent.setTimestamp(event.getTimestamp()) ;
		cargodetevent.setConfidence(event.getCargoObject().getConfidence()) ;
		cargodetevent.setX(event.getCargoObject().getX()) ;
		cargodetevent.setY(event.getCargoObject().getY()) ;
		cargodetevent.setZ(event.getCargoObject().getZ()) ;
		cargodetevent.setWidth(event.getCargoObject().getWidth()) ;
		cargodetevent.setDepth(event.getCargoObject().getDepth()) ;
		cargodetevent.setHeight(event.getCargoObject().getHeight()) ;
		cargodetevent.setSc_depth(event.getCargoObject().getSc_depth()) ;
		cargodetevent.setSc_width(event.getCargoObject().getSc_width()) ;
		cargodetevent.setSc_height(event.getCargoObject().getSc_height()) ;
		cargodetevent.setImg(event.getImage()) ;
		cargodetevent.setPointcloud(event.getPointcloud()) ;
		
		
		Event event1 = new Event();
		
		event1.setEventsid(event.getCargoeventtype());
		
			event1.setReceiveddate(dateFormat.format(date));
		
		event1.setTimestamp(event.getTimestamp());
		event1.setClientid(event.getClientid());
		event1.setImage(event.getImage());
		event1.setPointcloud(event.getPointcloud());
		
		eventRepos.save(event1);
		
		// TODO: transform request Objects to database model
	//	return repos.saveCargoEvent(event);
		return repos.save(cargodetevent);
	}
	
	
	@PutMapping
	public CargoDetEvent updateCargoDetEvent(@RequestBody CargoDetEvent event)
	{
		return repos.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCargoDetEvent(@PathVariable("id") Long  id)
	{
		 repos.deleteById(id);
	}
}
