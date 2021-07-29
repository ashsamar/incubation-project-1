package com.zf.cs.db.controller;

import java.util.List;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.Event;
import com.zf.cs.repository.EventRepository;
import com.zf.cs.service.EventService;
import com.zf.cs.util.ReportUtil;

@Controller
public class EventController {
	
	@Autowired
	private EventService service;
	
	@Autowired
	private EventRepository repository;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	private ServletContext servletContext;
	

	@RequestMapping("/showCreateEvent")
	public String showCreate()
	{
		return "CreateEvent";
	}
	
	@RequestMapping("/saveEvent")
	public String saveClient(@ModelAttribute("event")Event event,ModelMap modelmap)
	{
		
		Event savedEvent = service.saveEvent(event);
		
		String msg = "succesfully saved with id: " +savedEvent.getId();
		
		modelmap.addAttribute("msg", msg);
		
		return "CreateEvent";
	}
	
	@RequestMapping("/displayEvents")
	public String displayEvent(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<Event>	allEvents = service.getAllEvents();
	modelmap.addAttribute("allEvents",allEvents);
	
		return "displayEvents";
	}
	
	

	@RequestMapping("/displayEvents1")
	public String displayEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
		List<Event>	allEvents = repository.findEvents(id);
		
//	List<Event>	allEvents = service.getAllEvents();
	modelmap.addAttribute("allEvents",allEvents);
	
		return "displayEvents";
	}


	@RequestMapping("/deleteEvent")
	public String deleteClient(@RequestParam("id")Long id,ModelMap modelmap)
	{
		Event event = service.getEventById(id);
		
		service.deleteEvent(event);
		
		
		List<Event>	allEvents = service.getAllEvents();
		modelmap.addAttribute("allEvents",allEvents);
		return "displayEvents";
	}
	
	@RequestMapping("/showUpdateEvent")
	public String updateEvent(@RequestParam("id")Long id,ModelMap modekmap)
	{
		Event event =	service.getEventById(id);
	modekmap.addAttribute("client", event);
		return "updateEvent";
	}
	
	@RequestMapping("/updatedEvent")
	public String updatedEvent(@ModelAttribute("event") Event event,ModelMap modelmap)
	{
		
		service.updateEvent(event);
		
		
		List<Event>	allEvents = service.getAllEvents();
		modelmap.addAttribute("allEvents",allEvents);
		return "displayEvents";
	}
	
	@RequestMapping("/generateReportEvent")
	public String generateReport()
	{
		
		String path = servletContext.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		
		return "report";
	}
	
}
