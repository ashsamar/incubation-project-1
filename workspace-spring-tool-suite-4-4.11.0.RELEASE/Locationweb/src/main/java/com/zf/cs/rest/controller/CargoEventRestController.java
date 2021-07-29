package com.zf.cs.rest.controller;

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

@RestController
@RequestMapping("/cargoEvents")
public class CargoEventRestController {

	
	@Autowired
	private CargoDetecEventRepository repos;
	
	
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
	public CargoDetEvent addCargoDetEvent(@RequestBody CargoDetEvent event)
	{
		// TODO: transform request Objects to database model
	//	return repos.saveCargoEvent(event);
		return repos.save(event);
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
