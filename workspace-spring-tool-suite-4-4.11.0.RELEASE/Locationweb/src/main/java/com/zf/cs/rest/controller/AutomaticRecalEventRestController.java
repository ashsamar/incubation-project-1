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

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.repository.AutomaticRecalEventRepository;
import com.zf.cs.repository.CargoDetecEventRepository;

@RestController
@RequestMapping("/automaticRecalEvents")
public class AutomaticRecalEventRestController {
	
	
	
	
	@Autowired
	private AutomaticRecalEventRepository repos;
	
	
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
	public AutomaticRecalEvent addAutomaticRecalEvent(@RequestBody AutomaticRecalEvent event)
	{
		return repos.save(event);
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
