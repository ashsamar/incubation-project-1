package com.zf.cs.db.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.zf.cs.db.model.CargoDetEvent;
import com.zf.cs.db.model.MovementDetEvent;
import com.zf.cs.repository.CargoDetecEventRepository;
import com.zf.cs.repository.MovementDetEventRepository;
import com.zf.cs.service.CargoDetecEventService;
import com.zf.cs.service.MovementDetEventService;
import com.zf.cs.util.ReportUtil;

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

	
	
	@RequestMapping("/displayMovementDetEventImage")
	public String displayCargoDetecEventImage(@RequestParam("id")Long id,ModelMap modelmap,
			HttpServletRequest request,HttpServletResponse response)
	{
		
		
	//	List<Objects>	allObjects = repository.findObjects(id);
		modelmap.addAttribute("clientId", id);
		System.out.println("till here");
	List<MovementDetEvent>	allObjects = service.getAllCargoDetecEvents();
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
	
		return "displayMovementDetEvent";
	}

	
	

	@RequestMapping("/displayMovementDetEventPointCloud")
	public ResponseEntity<ByteArrayResource> displayCargoDetecEventPointCloud(@RequestParam("id")Long id)
	{
		
		
		MovementDetEvent doc  = service.getCargoDetecEventById(id);
	
	return ResponseEntity.ok()
		//	.contentType(MediaType.parseMediaType("/doc.getCargoeventtype()"))
			.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getMovementeventtype()+"\"")
			.body(new ByteArrayResource(doc.getPointcloud()));
	
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
