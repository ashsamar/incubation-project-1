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
import com.hussain.location.entities.MovementDetEvent;
import com.hussain.location.repos.CargoDetecEventRepository;
import com.hussain.location.repos.MovementDetEventRepository;
import com.hussain.location.service.CargoDetecEventService;
import com.hussain.location.service.MovementDetEventService;
import com.hussain.location.util.ReportUtil;

@Controller
public class MovementDetEventController {

	
	@Autowired
	private MovementDetEventService service;
	
	@Autowired
	private MovementDetEventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	@RequestMapping("/showCreateMovementDetEvent")
	public String showCreate()
	{
		return "CreateMovementDetEvent";
	}
	
	@RequestMapping("/saveCreateMovementDetEvent")
	public String saveCargoDetecEvent(@ModelAttribute("movementDetEvent")MovementDetEvent object,ModelMap modelmap)
	{
		
		MovementDetEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreateMovementDetEvent";
	}
	
	@RequestMapping("/displayMovementDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<MovementDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
		return "displayMovementDetEvent";
	}
	
	

	@RequestMapping("/displayMovementDetEvent1")
	public String displayCargoDetecEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<MovementDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayMovementDetEvent";
	}


	@RequestMapping("/deleteMovementDetEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		MovementDetEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<MovementDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allMovementDetEvents",allObjects);
		return "displayMovementDetEvents";
	}
	
	@RequestMapping("/showUpdateMovementDetEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		MovementDetEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updateMovementDetEvent";
	}
	
	@RequestMapping("/updatedMovementDetEvent")
	public String updatedObject(@ModelAttribute("object")MovementDetEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<MovementDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayMovementDetEvents";
	}
	
}
