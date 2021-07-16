package com.hussain.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hussain.location.entities.Location;
import com.hussain.location.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService service;

	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "CreateLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location")Location location,ModelMap modelmap)
	{
		
		Location savedLocation = service.saveLocation(location);
		
		String msg = "succesfully saved with id" +savedLocation.getId();
		
		modelmap.addAttribute("msg", msg);
		
		return "CreateLocation";
	}
	

}
