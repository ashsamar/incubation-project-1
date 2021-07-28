package com.hussain.location.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hussain.location.entities.AutomaticRecalEvent;
import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.repos.AutomaticRecalEventRepository;
import com.hussain.location.service.AutomaticRecalEventService;

@Controller
public class AutomaticRecalEventController {

	@Autowired
	private AutomaticRecalEventRepository repository;
	
	@Autowired
	private AutomaticRecalEventService service;
	
	
	

	@RequestMapping("/showCreateAutomaticRecalEvent")
	public String showCreate()
	{
		return "CreateAutomaticRecalEvent";
	}
	
	@RequestMapping("/saveAutomaticRecalEvent")
	public String saveCargoDetecEvent(@ModelAttribute("automaticRecalEvent")AutomaticRecalEvent object,ModelMap modelmap)
	{
		
		AutomaticRecalEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreateCargoDetecEvent";
	}
	
	@RequestMapping("/displayAutomaticRecalDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap, HttpServletResponse response) throws 
	ServletException,SQLException
	{
		
	
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<AutomaticRecalEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
//	byte[] image = service.getCargoDetecEventImageById(id);
//	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
//	
//	try {
//		response.getOutputStream().write(image);
//		response.getOutputStream().flush();
//		response.getOutputStream().close();
//	} catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	try {
//		ServletOutputStream outputStream = response.getOutputStream();
//		
//		outputStream.write(image);
//	//	outputStream.flush();
//		outputStream.close();
//		
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

//	modelmap.addAttribute("image",image);
	
	
	
		return "displayAutomaticRecalEvent";
	}
	
	

	@RequestMapping("/displayAutomaticRecalDetEvent1")
	public String displayCargoDetecEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<AutomaticRecalEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayAutomaticRecalEvent";
	}

	
	@RequestMapping("/displayAutomaticRecalDetEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<AutomaticRecalEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	byte[] image = service.getCargoDetecEventImageById(id);
	response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	
	try {
		response.getOutputStream().write(image);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		return "displayAutomaticRecalEvent";
	}

	
	

	@RequestMapping("/displayAutomaticRecalDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		AutomaticRecalEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getAutomaticrecaleventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
	

	@RequestMapping("/deleteAutomaticRecalDetEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		AutomaticRecalEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<AutomaticRecalEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayCargoDetecEvents";
	}
	
	@RequestMapping("/showUpdateAutomaticRecalDetEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		AutomaticRecalEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updateAutomaticRecalEvent";
	}
	
	@RequestMapping("/updatedAutomaticRecalDetEvent")
	public String updatedObject(@ModelAttribute("object")AutomaticRecalEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<AutomaticRecalEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayCargoDetecEvents";
	}
	

	
	
}
