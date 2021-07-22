package com.hussain.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hussain.location.entities.CargoDetEvent;


import com.hussain.location.repos.CargoDetecEventRepository;

import com.hussain.location.service.CargoDetecEventService;
import com.hussain.location.util.ReportUtil;

@Controller
public class CargoDetecEventController {
	
	@Autowired
	private CargoDetecEventService service;
	
	@Autowired
	private CargoDetecEventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	@RequestMapping("/showCreateCargoDetecEvent")
	public String showCreate()
	{
		return "CreateCargoDetecEvent";
	}
	
	@RequestMapping("/saveCargoDetecEvent")
	public String saveCargoDetecEvent(@ModelAttribute("cargoDetecEvent")CargoDetEvent object,ModelMap modelmap)
	{
		
		CargoDetEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreateCargoDetecEvent";
	}
	
	@RequestMapping("/displayCargoDetecEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
		return "displayCargoDetecEvent";
	}
	
	

	@RequestMapping("/displayCargoDetecEvent1")
	public String displayCargoDetecEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayCargoDetecEvent";
	}


	@RequestMapping("/deleteCargoDetecEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		CargoDetEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayCargoDetecEvents";
	}
	
	@RequestMapping("/showUpdateCargoDetecEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		CargoDetEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updateCargoDetecEvent";
	}
	
	@RequestMapping("/updatedCargoDetecEvent")
	public String updatedObject(@ModelAttribute("object")CargoDetEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<CargoDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayCargoDetecEvents";
	}
	

}
