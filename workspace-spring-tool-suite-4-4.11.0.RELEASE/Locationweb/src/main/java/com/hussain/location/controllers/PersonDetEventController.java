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

import com.hussain.location.entities.CargoDetEvent;
import com.hussain.location.entities.PersonDetEvent;
import com.hussain.location.repos.PersonDetEventRepository;
import com.hussain.location.service.PersonDetEventService;

@Controller
public class PersonDetEventController {

	@Autowired
	private PersonDetEventRepository repository;
	
	@Autowired
	private PersonDetEventService service;
	
	
	
	
	
	
	@RequestMapping("/showCreatePersonDetEvent")
	public String showCreate()
	{
		return "CreatePersonDetEvent";
	}
	
	@RequestMapping("/savePersonDetEvent")
	public String saveCargoDetecEvent(@ModelAttribute("personDetEvent")PersonDetEvent object,ModelMap modelmap)
	{
		
		PersonDetEvent savedObject = service.saveCargoDetecEvent(object);
		
	//	String msg = "succesfully saved with id: " +savedObject.getId();
		
	//	modelmap.addAttribute("msg", msg);
		
		return "CreatePersonDetEvent";
	}
	
	@RequestMapping("/displayPersonDetEvent")
	public String displayCargoDetecEvent(@RequestParam("id")Long id,ModelMap modelmap, HttpServletResponse response) throws 
	ServletException,SQLException
	{
		
	
	//	List<Event>	allEvents = repository.findEvents(id);
		modelmap.addAttribute("clientId", id);
	List<PersonDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
	
	
		return "displayPersonDetEvent";
	}
	
	

	@RequestMapping("/displayPersonDetEvent1")
	public String displayCargoDetecEvent1(@RequestParam("id")Long id,ModelMap modelmap)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<PersonDetEvent>	allObjects = service.getAllCargoDetecEvents();
	modelmap.addAttribute("allObjects",allObjects);
	
	
	
		return "displayPersonDetEvent";
	}

	
	@RequestMapping("/displayPersonDetEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<PersonDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
		return "displayPersonDetEvent";
	}

	
	

	@RequestMapping("/displayPersonDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		PersonDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getPersondeteventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
	}
	
	
	
	

	@RequestMapping("/deletePersonDetEvent")
	public String deleteObject(@RequestParam("id")Long id,ModelMap modelmap)
	{
		PersonDetEvent object = service.getCargoDetecEventById(id);
		
		service.deleteCargoDetecEvent(object);
		
		
		List<PersonDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayPersonDetEvents";
	}
	
	@RequestMapping("/showUpdatePersonDetEvent")
	public String updateObjet(@RequestParam("id")Long id,ModelMap modekmap)
	{
		PersonDetEvent object =	service.getCargoDetecEventById(id);
	modekmap.addAttribute("object", object);
		return "updatePersonDetEvent";
	}
	
	@RequestMapping("/updatedPersonDetEvent")
	public String updatedObject(@ModelAttribute("object")PersonDetEvent object,ModelMap modelmap)
	{
		
		service.updateCargoDetecEvent(object);
		
		
		List<PersonDetEvent>	allObjects = service.getAllCargoDetecEvents();
		modelmap.addAttribute("allCargoDetecEvents",allObjects);
		return "displayPersonDetEvent";
	}
	
}
