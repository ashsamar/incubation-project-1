package com.hussain.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.location.entities.Location;
import com.hussain.location.repos.LocationRepository;

@RestController
public class LocationRestController {
	
	@Autowired
	LocationRepository repository;
	
	
	@GetMapping
	public List<Location> getAllLocations()
	{
		
		List<Location> allLocations = repository.findAll();
		return allLocations;
	}
	
	
	@PostMapping
	public Location createLocation(@RequestBody Location location)
	{
		return repository.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location)
	{
		return repository.save(location);
	}
	
//	@DeleteMapping("/{id}")
//	public void deleteLocation(@PathVariable("id") int id)
//	{
//		 repository.deleteById(id);
//	}
	
	
//	@GetMapping("/{id}")
//	public void getOneLocation(@PathVariable("id") int id)
//	{
//		 repository.findById(id);
//	}
	

}
