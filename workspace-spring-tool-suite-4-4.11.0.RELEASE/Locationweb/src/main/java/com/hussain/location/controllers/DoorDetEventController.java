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
import com.hussain.location.entities.DoorDetEvent;
import com.hussain.location.repos.CargoDetecEventRepository;
import com.hussain.location.repos.DoorDetEventRepository;
import com.hussain.location.service.CargoDetecEventService;
import com.hussain.location.service.DoorDetEventService;
import com.hussain.location.util.ReportUtil;

@Controller
public class DoorDetEventController {

	
	
	@Autowired
	private DoorDetEventService service;
	
	@Autowired
	private DoorDetEventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	@RequestMapping("/showCreateDoorDetEvent")
	public String showCreate()
	{
		return "CreateDoorDetEvent";
	}
	
	@RequestMapping("/saveDoorDetEvent")
	public String saveCargoDetecEvent(@ModelAttribute("doorDetEvent")DoorDetEvent object,ModelMap modelmap)
	{
		
		DoorDetEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreateCargoDetecEvent";
	}
	
	@RequestMapping("/displayDoorDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
		return "displayDoorDetEvent";
	}
	
	

	@RequestMapping("/displayDoorDetEvent1")
	public String displayCargoDetecEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayCargoDetecEvent";
	}


	@RequestMapping("/deleteDoorDetEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		DoorDetEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allDoorDetEvent",allObjects);
		return "displayDoorDetEvents";
	}
	
	@RequestMapping("/showUpdateDoorDetEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		DoorDetEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updateDoorDetEvent";
	}
	
	@RequestMapping("/updatedDoorDetEvent")
	public String updatedObject(@ModelAttribute("object")DoorDetEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<DoorDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allDoorDetEvents",allObjects);
		return "displayDoorDetEvents";
	}
	
}
